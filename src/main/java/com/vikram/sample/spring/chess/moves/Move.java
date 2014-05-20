/**
* 'Move' has all the properties related to a chess move 
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

import com.vikram.sample.spring.chess.position.Position.Side;

public class Move {
	
	public enum SpecialMoveType {
		NORMAL, SHORT_CASTLING, LONG_CASTLING, ENPASSANT
	}
	
	public enum GameResult {
		WHITE_WINS, BLACK_WINS, DRAW, IN_PROGRESS
	}
	
	private int moveNumber;
	private Side side;
	private SpecialMoveType specialMoveType = SpecialMoveType.NORMAL;
	private String sourceSquare;
	private String targetSquare;
	private GameResult gameResult = GameResult.IN_PROGRESS;
	
	public int getMoveNumber() {
		return moveNumber;
	}
	
	public void setMoveNumber(int moveNumber) {
		this.moveNumber = moveNumber;
	}
		
	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public SpecialMoveType getSpecialMoveType() {
		return specialMoveType;
	}
	
	public void setSpecialMoveType(SpecialMoveType specialMoveType) {
		this.specialMoveType = specialMoveType;
	}

	public String getSourceSquare() {
		return sourceSquare;
	}

	public void setSourceSquare(String sourceSquare) {
		this.sourceSquare = sourceSquare;
	}

	public String getTargetSquare() {
		return targetSquare;
	}

	public void setTargetSquare(String targetSquare) {
		this.targetSquare = targetSquare;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}		
				
}
