/**
* Test class for KingMoveValidator 
*
* @author  Vikram Kamath
* @version 1.0
* @since 01-11-2013 
*/

package com.vikram.sample.spring.chess.moves;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vikram.sample.spring.chess.position.Position;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/vikram/sample/spring/chess/beans.xml")
public class KingMoveValidatorTest {
	
	@Autowired
	private Position position;
	
	@Before
	public void setUp() throws Exception {
		position = new Position();
		position.setPositionMatrix( new char[][]{ 
			{'R', 'N', 'B', 'n', 'K', '*', 'N', 'R'}, // 1st rank
			{'P', '*', '*', 'r', '*', 'P', 'P', 'P'}, // 2nd rank
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 3rd rank
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 4th rank
			{'*', '*', '*', 'B', '*', '*', '*', '*'}, // 5th rank
			{'*', '*', '*', '*', '*', '*', '*', '*'}, // 6th rank
			{'*', '*', '*', 'p', 'p', 'p', 'p', 'p'}, // 7th rank
			{'*', 'Q', 'b', 'q', 'k', 'b', 'n', 'r'}, // 8th rank
	       // A    B    C    D    E    F    G    H 
		});
	}
	
	@Test
	public void testValidMove() {
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "e2");
		assertTrue(validator.isValidMove());						
	}
	
	@Test
	public void testInvalidMove() {
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "d3");
		assertFalse(validator.isValidMove());						
	}
	
	@Test
	public void testInvalidJumpMove() {
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "g3");
		assertFalse(validator.isValidMove());						
	}
	
	@Test
	public void testPieceCapture() {		
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "d2");
		assertTrue(validator.isValidMove());						
	}
	
	@Test
	public void testInvalidPieceCapture() {
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "d1");
		assertFalse(validator.isValidMove());						
	}
	
	@Test
	public void testSameSidePieceCapture() {
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "f2");
		assertFalse(validator.isValidMove());						
	}
	
	@Test
	public void testValidCastling() {
		position.setPositionMatrix( new char[][]{ 
				{'R', 'N', 'B', 'Q', 'K', '*', '*', 'R'}, // 1st rank
				{'P', 'P', 'P', 'P', 'P', 'P', '*', 'P'}, // 2nd rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 3rd rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 4th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 5th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 6th rank
				{'*', '*', '*', 'p', 'p', 'p', '*', 'p'}, // 7th rank
				{'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}, // 8th rank
		       // A    B    C    D    E    F    G    H 
			});
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "g1");
		assertFalse(validator.isValidMove());	
	}
	
	@Test
	public void testInvalidCastling() {
		position.setPositionMatrix( new char[][]{ 
				{'R', '*', '*', '*', 'K', 'B', 'N', 'R'}, // 1st rank
				{'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, // 2nd rank
				{'*', '*', 'n', '*', '*', '*', '*', '*'}, // 3rd rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 4th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 5th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 6th rank
				{'*', '*', '*', 'p', 'p', 'p', '*', 'p'}, // 7th rank
				{'r', '*', 'b', 'q', 'k', 'b', 'n', 'r'}, // 8th rank
		       // A    B    C    D    E    F    G    H 
			});
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "c1");
		assertFalse(validator.isValidMove());	
	}
	
	@Test
	public void testcheckedSquareMove() {
		position.setPositionMatrix( new char[][]{ 
				{'R', '*', '*', '*', 'K', 'B', 'N', 'R'}, // 1st rank
				{'P', 'P', 'P', 'P', '*', 'P', 'P', 'P'}, // 2nd rank
				{'*', '*', 'n', '*', '*', '*', '*', '*'}, // 3rd rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 4th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 5th rank
				{'*', '*', '*', '*', '*', '*', '*', '*'}, // 6th rank
				{'*', '*', '*', 'p', 'p', 'p', '*', 'p'}, // 7th rank
				{'r', '*', 'b', 'q', 'k', 'b', 'n', 'r'}, // 8th rank
		       // A    B    C    D    E    F    G    H 
			});
		MoveValidator validator = MoveValidator.getInstance(position, "e1", "e2");
		assertFalse(validator.isValidMove());	
	}
	
}
