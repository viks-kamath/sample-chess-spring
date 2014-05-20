/**
* PawnMoveValidator checks all possibilities of Pawn moves 
* and says whether the given move made by the piece (Pawn) 
* is within the international chess rules
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class PawnMoveValidator extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {
		//TODO: Implementation goes here
		//TODO: dependency on positions owing to en-passant rule
		
		//TODO: After completing the above
		//....&& if (!isEnpassant()) return false;
		return true;
	}

	private boolean isEnpassant() {
		//TODO: Implementation goes here
		//TODO: Also check if enPassant is allowed in this position.
		//...requires knowledge of previous position
		//TODO: If not enPassant, return false
		//TODO: Complete the above code and proceed
		specialMoveType = specialMoveType.ENPASSANT;
		return true;		
	}
}
