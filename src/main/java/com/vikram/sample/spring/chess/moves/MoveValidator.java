/**
* For all possibilities, evaluate and find out if the given move
* is made as per the international chess rules
* This is the base abstract class for the above implementation
* 
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

import com.vikram.sample.spring.chess.moves.Move.SpecialMoveType;
import com.vikram.sample.spring.chess.position.Position;
import com.vikram.sample.spring.chess.position.Position.PieceColor;
import com.vikram.sample.spring.chess.position.Position.Side;
import com.vikram.sample.spring.chess.position.PositionMatrixPoint;

//'Template Pattern' is used to implement the chess move validation 
public abstract class MoveValidator {
	
	protected com.vikram.sample.spring.chess.position.Position position;
	protected String sourceSquareName;
	protected String targetSquareName;	
	protected int x1, y1, x2, y2; // Matrix points coordinates
	protected SpecialMoveType specialMoveType = SpecialMoveType.NORMAL;
	
	public static MoveValidator getInstance (Position position, String sourceSquareName, String targetSquareName) {		
		char piece = position.getPieceAt(sourceSquareName);
		MoveValidator moveValidator = null;
		
		// Pick the appropriate instance
		switch (piece) {
			case 'R': 
			case 'r': moveValidator = new RookMoveValidator(); break;
			case 'N': 
			case 'n': moveValidator = new KnightMoveValidator(); break;
			case 'B': 
			case 'b': moveValidator = new BishopMoveValidator(); break;
			case 'Q': 
			case 'q': moveValidator = new QueenMoveValidator(); break;
			case 'K': 
			case 'k': moveValidator = new KingMoveValidator(); break;
			case 'P': 
			case 'p': moveValidator = new PawnMoveValidator(); break;
			case '*': moveValidator = new DummyValidator(); break;
			default: throw new RuntimeException("MoveValidator::getInstance(Position position, String sourceSquareName, String targetSquareName) method : " +
					"Unrecognized piece '" + piece + "'");			
		}
		
		// Initialise
		moveValidator.position = position;
		moveValidator.sourceSquareName = sourceSquareName;
		moveValidator.targetSquareName = targetSquareName;
		
		PositionMatrixPoint point1 = new PositionMatrixPoint(sourceSquareName);
		PositionMatrixPoint point2 = new PositionMatrixPoint(targetSquareName);
		moveValidator.x1 = point1.c;
		moveValidator.y1 = point1.r;
		moveValidator.x2 = point2.c;
		moveValidator.y2 = point2.r;
		
		return moveValidator;
	}		
	
	/* 
	 * This is a template method and hence marked final
	 */
	public final boolean isValidMove() { 
		
		if (position.getPieceAt(sourceSquareName) == '*') {
			// The player hasn't selected any piece to move!
			return false;
		}
		
		if (!isValidSideToMove()) {
			// A Player cannot make a move when it's not his turn
			return false;
		}
		
		if (isSameSquare()) {
			// Source & destination squares are the same, and hence the move is not valid.
			return false; 
		}
		
		if (ownPieceCapture()) {
			// A player cannot kill his own piece
			return false; 
		}
			
		if (!isValidPieceMove()) return false;
		
		if (willBeUnderCheck()) return false;
		
		return true;
	}
	
	// Are Source & destination squares the same?
	private boolean isSameSquare() { 
		if (x1 == x2 && y1 == y2) 
			return true;
		return false;
	}
	
	// Has the player killed/captured their own piece?
	private boolean ownPieceCapture() {
		if (position.getPieceColorAt(sourceSquareName) == position.getPieceColorAt(targetSquareName)) 
			return true;
		return false;
	}
	
	private boolean isValidSideToMove() {
		PieceColor color1 = position.getPieceColorAt(sourceSquareName);
		Side color2 = position.getSideToMove();		
		if (color1 == PieceColor.WHITE && color2 == Side.WHITE) return true;
		if (color1 == PieceColor.BLACK && color2 == Side.BLACK) return true;
		return false;
	}		
	
	private boolean willBeUnderCheck () { // finds out if the current side-to-move will be under check if the move is made
		//TODO: Implementation goes here
		//TODO: dependency on position. Iterate through each and every square
		//TODO: A better approach, if possible, needs to be found to avoid such iteration using the position
		return false;
	}
	
	public boolean isUnderCheck(Position position, Side side) { // finds out if 'side' is under check in the given position
		//TODO: Implementation goes here
				//TODO: dependency on position. Iterate through each and every square
				//TODO: A bettervapproac if possible to be found to avoid such iteration using the position
		return false;
	}		
	
	public SpecialMoveType getSpecialMoveType() {
		return specialMoveType;
	}

	protected abstract boolean isValidPieceMove();		
}
