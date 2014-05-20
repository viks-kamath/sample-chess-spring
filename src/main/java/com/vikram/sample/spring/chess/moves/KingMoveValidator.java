/**
* KingMoveValidator checks all possibilities of King moves 
* and says whether the given move made by the piece (King) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class KingMoveValidator extends MoveValidator {    
	@Override
	protected boolean isValidPieceMove() {
		String str = "" + Math.abs(x2 - x1) + Math.abs(y2 - y1);	
		
		if ( !(str.equals("11") || str.equals("01")) || str.equals("10") ) {			
			if (str.equals("20")) return isCastling(); // see if castling is allowed in the given position for the given side
			// King can only move 'one step horizontal and two steps vertical' or vice-versa
			return false;   
		}
					
		return true;
	}
	
	private boolean isCastling() {
		//TODO: Implementation goes here
		if (!isShortCastling() && !isLongCastling()) return false;
		return true;
	}	
	
	private boolean isShortCastling() {
		//TODO: Implementation goes here
		//TODO: Also check if short-castling is allowed in this position.
		//...requires knowledge of positions
		//TODO: If not short-castling, return false
		//TODO: Complete the above code and proceed
		specialMoveType = specialMoveType.SHORT_CASTLING;
		return true;
	}

	private boolean isLongCastling() {
		//TODO: Implementation goes here
		//TODO: Also check if long-castling is allowed in this position.
		//...requires knowledge of positions
		//TODO: If not long-castling, return false
		//TODO: Complete the above code and proceed
		specialMoveType = specialMoveType.LONG_CASTLING;
		return true;
	}
}
