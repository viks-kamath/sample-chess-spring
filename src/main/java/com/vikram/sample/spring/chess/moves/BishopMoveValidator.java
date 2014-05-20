/**
* BishopMoveValidator checks all possibilities of Bishop moves 
* and says whether the given move made by the piece (Bishop) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class BishopMoveValidator extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {
		// Bishop can only move diagonally
		if ( !( Math.abs(x1 - x2) == Math.abs(y1 - y2) )) {
			System.out.println("Bishop can only move diagonally.");
			return false;
		}
				
		int verticalIncrement = (y2 - y1) / Math.abs(y2 - y1);
		int horizontalIncrement = (x2 - x1) / Math.abs(x2 - x1);
		
		// Check if in-between squares are non-vacant. If so, the move is illegal (invalid)
		// i.e. Bishop cannot hop over other piece/pieces.
		for ( int x = x1 + horizontalIncrement, y = y1 + verticalIncrement; 
				!(x == x2 && y == y2); // iterates through all squares after source square & before target square 
				x += horizontalIncrement, y += verticalIncrement) {					
			if (position.getPieceAt(y,x) != '*') {
				// Bishop cannot hop over other piece/pieces
				return false; 
			}
		}
		
		return true;
	}

}