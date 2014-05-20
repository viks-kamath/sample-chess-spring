/**
* Test class for SquareNameValidator 
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

import org.junit.Test;
import static org.junit.Assert.fail;

public class SquareNameValidatorTest {		
	
	@Test(expected = RuntimeException.class)
	public void testInvalidSquare() {		
		SquareNameValidator.failForInvalidSquare("a9");										
	}						
	
	@Test(expected = RuntimeException.class)
	public void testInvalidLength() {		
		SquareNameValidator.failForInvalidSquare("i33");										
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidFormat() {		
		SquareNameValidator.failForInvalidSquare("4a");										
	}
	
	@Test(expected = RuntimeException.class)
	public void testEmptyString() {		
		SquareNameValidator.failForInvalidSquare("");										
	}
	
	@Test(expected = RuntimeException.class)
	public void testNullInput() {		
		SquareNameValidator.failForInvalidSquare(null);										
	}
	
	@Test
	public void testValidSquare() {		
		try {
			SquareNameValidator.failForInvalidSquare("a1");
		}
		catch(RuntimeException e) {
			fail();
		}
	}
}
