/**
* RookMoveValidator checks all possibilities of Rook moves 
* and says whether the given move made by the piece (Rook) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class RookMoveValidator extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {
		// Rook can only move straight (vertically or horizontally)
		if ( !( x1 == x2 || y1 == y2) ) {
			return false;
		}

		int verticalIncrement = 0;
		int horizontalIncrement = 0;
		if (x1 == x2) {
			verticalIncrement = (y2 > y1) ? 1 : -1; // if it reaches here, y1 # y2			
		} else { // if it reaches here, y1 = y2
			horizontalIncrement = (x2 > x1) ? 1 : -1; // if it reaches it, x1 # x2
		}
		
		// Check if in-between squares are non-vacant. If so, the move is illegal (invalid)
		// i.e. Rook cannot hop over other piece/pieces.
		for ( int x = x1 + horizontalIncrement, y = y1 + verticalIncrement; 
				!(x == x2 && y == y2); // iterates through all squares after source square & before target square 
				x += horizontalIncrement, y += verticalIncrement) {				
					if (position.getPieceAt(y,x) != '*') {
					// Rook cannot hop over other piece/pieces
					return false; 
			}
		}

		return true;
	}	

}
