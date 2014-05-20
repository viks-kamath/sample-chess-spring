/**
* PositionMatrixPoint is a matrix representation of the way different pieces 
* are placed on the chess board. 
* The files (vertical rows) are represented as a, b, c, d, e, f, g, h
* The ranks (horizontal rows) are represented as 1, 2, 3, 4, 5, 6, 7, 8
* Each white colored piece is represented in corresponding upper case character
* Each black colored piece is represented in corresponding lower case character
* The character that represents the piece is the starting letter of its name (e.g. King -> 'K' or 'k'), 
* ..except for Knight that is represented as 'N' or 'n' 
* 
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.position;

import com.vikram.sample.spring.chess.moves.SquareNameValidator;

public class PositionMatrixPoint {
	// The matrix origin is set to bottom left (origin) rather than from top left in order to keep it consistent with Chess coordinates
	// The matrix indices are started from (0,0) rather than (1,1) in order to keep it consistent with programming language concepts
	public int r; // represents horizontal rows (or 'ranks' in chess terminology) starting from 0 index
				  // ... hence it also represents the first dimension of the position matrix (2D array)
	public int c; // represents vertical columns (or 'files' in chess terminology) starting from 0 index
      	          // ... hence it also represents the second dimension of the position matrix (2D array)
	         // Thus 'A1' in chess notation (File = A, Rank = 1) means (r,c) = (0,0)
	         // ... and 'H8' means (r,c) = (7,7)
	              // 'r' & 'c' are of public scope for simplicity, breaking the rules of encapsulation. 
	              // ... Remember that java.awt.Point has similar idea where x,y are of default scope.
	
	//TODO: Refactor the scope of 'r' and 'c' to default if necessary
	
	/* 'PositionMatrixPoint' instance is only used to convert from square name to matrix point
	 * for instance, to convert "A1" to r,c (0,0)  
	 */	
	public PositionMatrixPoint(String squareName) {
		SquareNameValidator.failForInvalidSquare(squareName);
		this.convertSquareNameToRC(squareName);				
	} 		
	
	private void convertSquareNameToRC(String squareName) {
		SquareNameValidator.failForInvalidSquare(squareName);
		char[] xCoordinates = {'A','B','C','D','E','F','G','H'};
		char[] yCoordinates = {'1','2','3','4','5','6','7','8'};
		int[] matrixIndices = {0,1,2,3,4,5,6,7};
		char xCoordinate = squareName.charAt(0);
		char yCoordinate = squareName.charAt(1);
		
		boolean isValidFile = false;
		boolean isValidRank = false;
		for (int i = 0 ; i < 8 ; i++) {
			if (xCoordinates[i] == Character.toUpperCase(xCoordinate)) {
				c = matrixIndices[i];
				isValidFile = true;
			}
			if (yCoordinate == yCoordinates[i]) {
				r = matrixIndices[i];
				isValidRank = true;
			}
		}
		
		if (!isValidFile || !isValidRank) {
			throw new RuntimeException("PositionMatrixPoint::convertSquareNameToRC(String squareName) method: 'squareName' should belong to {A1,A2,..,H8}");
		}				
	}		
	
	// Convert the position matrix point (r,c) to square name
	// e.g. (0,0) => "A1", (7,7) => "H8", (5,2) => "C6"
	public String toSquareName() {		
		char[] xCoordinates = {'A','B','C','D','E','F','G','H'};
		char[] yCoordinates = {'1','2','3','4','5','6','7','8'};
		int[] matrixIndices = {0,1,2,3,4,5,6,7};
		char xCoordinate = '\0';
		char yCoordinate = '\0';
		
		boolean isValidC = false;
		boolean isValidR = false;
		for (int i = 0 ; i < 8 ; i++) {
			if (c == matrixIndices[i]) {
				xCoordinate = xCoordinates[i];
				isValidC = true;
			}
			if (r == matrixIndices[i]) {
				yCoordinate = yCoordinates[i];
				isValidR = true;
			}			
		}
		
		if (!isValidC || !isValidR) {
			throw new RuntimeException("PositionMatrixPoint::getSquareName() method: 'r' & 'c' should belong to {0,1,2,3,4,5,6,7}");
		}
		
		return "" + xCoordinate + yCoordinate;
	}	
	
	public static String toSquareName(int r, int c) {		
		char[] xCoordinates = {'A','B','C','D','E','F','G','H'};
		char[] yCoordinates = {'1','2','3','4','5','6','7','8'};
		int[] matrixIndices = {0,1,2,3,4,5,6,7};
		char xCoordinate = '\0';
		char yCoordinate = '\0';
		
		boolean isValidC = false;
		boolean isValidR = false;
		for (int i = 0 ; i < 8 ; i++) {
			if (c == matrixIndices[i]) {
				xCoordinate = xCoordinates[i];
				isValidC = true;
			}
			if (r == matrixIndices[i]) {
				yCoordinate = yCoordinates[i];
				isValidR = true;
			}			
		}
		
		if (!isValidC || !isValidR) {
			throw new RuntimeException("PositionMatrixPoint::getSquareName() method: 'r' & 'c' should belong to {0,1,2,3,4,5,6,7}");
		}
		
		return "" + xCoordinate + yCoordinate;
	}
	
	@Override
	public String toString() {		
		return "PositionMatrixPoint: (r,c) = (" + r + "," + c + ")";
	}			
	
}
