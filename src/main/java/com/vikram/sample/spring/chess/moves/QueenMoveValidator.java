/**
* QueenMoveValidator checks all possibilities of Queen moves 
* and says whether the given move made by the piece (Queen) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class QueenMoveValidator extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {		
		if ( x1 == x2 || y1 == y2 ) { // if moved like Rook 			
			int verticalIncrement = 0;
			int horizontalIncrement = 0;
			if (x1 == x2) {
				verticalIncrement = (y2 > y1) ? 1 : -1; // if it reaches here, y1 # y2			
			} else { // if it reaches here, y1 = y2
				horizontalIncrement = (x2 > x1) ? 1 : -1; // if it reaches it, x1 # x2
			}
			// Check if in-between squares are non-vacant. If so, the move is illegal (invalid)
			// i.e. Queen cannot hop over other piece/pieces.
			for ( int x = x1 + horizontalIncrement, y = y1 + verticalIncrement; 
					!(x == x2 && y == y2); // iterates through all squares after source square & before target square 
					x += horizontalIncrement, y += verticalIncrement) {						
				if (position.getPieceAt(y,x) != '*') {
					// Queen cannot hop over other piece/pieces
					return false; // cannot hop over another piece
				}
			}
		} else if ( Math.abs(x1 - x2) == Math.abs(y1 - y2) ) { // if moved like Bishop
			int verticalIncrement = (y2 - y1) / Math.abs(y2 - y1);
			int horizontalIncrement = (x2 - x1) / Math.abs(x2 - x1);			
			// Check if in-between squares are non-vacant. If so, the move is illegal (invalid)
			// i.e. Queen cannot hop over other piece/pieces.
			for ( int x = x1 + horizontalIncrement, y = y1 + verticalIncrement; 
					!(x == x2 && y == y2); // iterates through all squares after source square & before target square 
					x += horizontalIncrement, y += verticalIncrement) {					
				if (position.getPieceAt(y,x) != '*') {
					// Queen cannot hop over other piece/pieces
					return false; // cannot hop over another piece
				}
			}
		} else {
			// Queen can only move straight or diagonally
			return false;
		}

		return true;
	}	

}
