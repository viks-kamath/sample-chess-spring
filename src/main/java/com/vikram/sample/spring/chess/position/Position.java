/**
* Position is a matrix representation of the way different pieces 
* are placed on the chess board. 
* The files (vertical rows) are represented as a, b, c, d, e, f, g, h
* The ranks (horizontal rows) are represented as 1,2,3,4,5,6,7,8
* Each white colored piece is represented in corresponding upper case character
* Each black colored piece is represented in corresponding lower case character
* The character that represents the piece is the starting letter of its name, 
* ..except for Knight that is represented as 'N' or 'n' 
* 
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.position;

import com.vikram.sample.spring.chess.moves.SquareNameValidator;

public class Position {	
	
	public enum PieceColor {
		WHITE, BLACK, NONE;
	}
	
	public enum Side {
		WHITE, BLACK;
	}
		
	private Side sideToMove = Side.WHITE; // who is supposed to make a move in this position
	
	private char[][] positionMatrix = 	
		{ 
			{'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}, // 1st rank and not 8th
			{'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, // 2nd rank and not 7th
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 3rd rank and not 6th
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 4th rank and not 5th
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 5th rank and not 4th
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 6th rank and not 3rd
			{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, // 7th rank and not 2nd
			{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}, // 8th rank and not 1st
	//Files:  A    B    C    D    E    F    G    H 
	// The above is a 2D representation of chess board position
		}; /* The physical look of this array doesn't coincide with that of board position, but the vertically reversed order does. 
			* This is done to coincide board-origin square (A1) with the array origin element position[0][0] 
			* which is correct as per both geometry and array representation in programming languages. 
			*/		

	public char[][] getPositionMatrix() {
		return positionMatrix;
	}

	public void setPositionMatrix(char[][] positionMatrix) {
		this.positionMatrix = positionMatrix;
	}
	
	public char getPieceAt (int r, int c) {
		return positionMatrix[r][c];
	}
	
	public char getPieceAt (Position anyPosition, int r, int c) {
		return anyPosition.getPositionMatrix()[r][c];
	}
	
	public String updatePositionAndGenerateMoveString(String sourceSquare, String targetSquare, String specialInstruction) {
		/* returns Algebraic notation move String as per FIDE rules: http://en.wikipedia.org/wiki/Algebraic_chess_notation
		 * This method assumes that the move has been already validated
		 * 'specialInstruction' applies to Pawn promotion, En-passant, Short-castling & Long-castling. 
		 	i) "ep" (non-case-sensitive) -> for En-passant 
		 	ii) "00" or "OO" (non-case-sensitive) -> for Short-castling
		 	iii) '000' or "OOO" (non-case-sensitive) -> for Long-castling
		 	ii) "R" -> for Pawn promotion to Rook
		 	iii) "N" -> for Pawn promotion to Knight
		 	iv) "B" -> for Pawn promotion to Bishop
		 	v) "Q" -> for Pawn promotion to Queen
		 	vi) "" or null -> for no special instruction
		 *  'sourceSquare' is just a 2-character string that represents the square where the piece should be moved from
		 *  'targetSquare' is just a 2-character string that represents the square where the piece should be moved to
		 */
		
		// TODO: The actual code goes here. 
		// TODO: Rename this method and/or refactor.
		
		return null;
	}
	
	public char getPieceAt (String squareName) {
		SquareNameValidator.failForInvalidSquare(squareName);
		PositionMatrixPoint matrixPoint = new PositionMatrixPoint(squareName); 
		return positionMatrix[matrixPoint.r][matrixPoint.c];
	}
	
	public char getPieceAt (Position anyPosition, String squareName) {
		SquareNameValidator.failForInvalidSquare(squareName);
		PositionMatrixPoint matrixPoint = new PositionMatrixPoint(squareName); 
		return anyPosition.getPositionMatrix()[matrixPoint.r][matrixPoint.c];
	}
	
	public PieceColor getPieceColorAt (String squareName) {
		char piece = this.getPieceAt(squareName);
		String whitePieces = "RNBQKP";
		String blackPieces = "rnbqkp";
		if (whitePieces.indexOf(piece) >= 0) {
			return PieceColor.WHITE;
		} else if (blackPieces.indexOf(piece) >= 0) {
			return PieceColor.BLACK;
		} else return PieceColor.NONE;
	}
		
	public PieceColor getPieceColorAt (Position anyPosition, String squareName) {
		char piece = this.getPieceAt(anyPosition, squareName);		
		String whitePieces = "RNBQKP";
		String blackPieces = "rnbqkp";
		if (whitePieces.indexOf(piece) >= 0) {
			return PieceColor.WHITE;
		} else if (blackPieces.indexOf(piece) >= 0) {
			return PieceColor.BLACK;
		} else return PieceColor.NONE;
	}							

	public Side getSideToMove() {
		return sideToMove;
	}

	public void setSideToMove(Side sideToMove) {
		this.sideToMove = sideToMove;
	}
	
	public void setSquareByName(String squareName, char piece) {
		PositionMatrixPoint matrixPoint = new PositionMatrixPoint(squareName);
		this.setSquareByRC(matrixPoint.r, matrixPoint.c, piece);
	}
	
	public void setSquareByRC(int row, int column, char piece) {		
		this.positionMatrix[row][column] = piece;
	}

	public void displayPositionBoard() {		
		for (int r = 7; r >=0 ; r--)
		{
			System.out.println();
			for (int c = 0; c <=7 ; c++) {
				System.out.print(this.positionMatrix[r][c]+"  ");
			}			
		}
		System.out.println();
	}		
	
	// This method is only used for debugging
	public void setPositionMatrixFromBoard(char[][] board) {
		for (int i = 0 ; i <= 7 ; i++) {
			for (int j = 0 ; j <= 7 ; j++) {
				positionMatrix[i][j] = board[7-i][j]; 
			}
		}
	}
	
}
