/**
* KnightMoveValidator checks all possibilities of Knight moves 
* and says whether the given move made by the piece (Knight) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class KnightMoveValidator  extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {
		
		String str = "" + Math.abs(x2 - x1) + Math.abs(y2 - y1);	
		if ( !(str.equals("12") || str.equals("21")) ) {
			// Knight can only move 'one step horizontal and two steps vertical' or vice-versa!
			return false;   
		}
					
		return true;
	}
	
}
