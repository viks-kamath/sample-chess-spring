/**
* SquareNameValidator checks if the given square name (e.g. "d4") is valid 
* is valid as per the international chess board representation
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class SquareNameValidator {
	
	public static void failForInvalidSquare(String squareName) {
		// 'squareName' has to be two-charactered		
		if (squareName == null || squareName.length() != 2 ) {
			throw new RuntimeException("SquareNameValidator::failForInvalidSquare(String squareName) constructor : 'squareName' has to be of exactly 2 characters");
		}
		
		// 'squareName' has to belong to {"A1","A2",..,"H8"}
		char xCoordinate = Character.toUpperCase(squareName.charAt(0));
		char yCoordinate = squareName.charAt(1);
		String xCoordinates = "ABCDEFGH";
		String yCoordinates = "12345678";
		int xIndex = xCoordinates.indexOf(xCoordinate);
		int yIndex = yCoordinates.indexOf(yCoordinate);
		if (xIndex == -1 || yIndex == -1) {
			throw new RuntimeException("SquareNameValidator::failForInvalidSquare(String squareName) method: 'squareName' should belong to {A1,A2,..,H8}");
		}						
	}
}
