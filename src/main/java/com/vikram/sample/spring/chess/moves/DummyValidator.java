/**
* DummyValidator stands for a move made by an empty piece  
* i.e. no piece is selected 
* As per international chess rules, this is not valid 
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

public class DummyValidator extends MoveValidator {

	@Override
	protected boolean isValidPieceMove() {
		return false; // This will always be false since the sourceSquare is empty 
		              // ... i.e. the piece in this position is stored as '*' 
	}	

}
