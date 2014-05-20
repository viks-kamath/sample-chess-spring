/**
* AllTests is a Test Suite  
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BishopMoveValidatorTest.class, RookMoveValidatorTest.class, QueenMoveValidatorTest.class,
				KnightMoveValidatorTest.class, KingMoveValidatorTest.class, PawnMoveValidatorTest.class,
				DummyValidatorTest.class, SquareNameValidatorTest.class})
public class AllTests {	
}
