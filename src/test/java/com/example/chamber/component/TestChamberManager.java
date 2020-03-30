package com.example.chamber.component;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestChamberManager {
	@Test
	void TestChamberMachineContructor(){
		ChamberManager chamberManager = new ChamberManager(1, "LR..RL");
		Assertions.assertEquals(1, chamberManager.getSpeed());
		Assertions.assertEquals(6, chamberManager.getChamberSize());
		Assertions.assertArrayEquals(new boolean[] {true, false, false, false, false, true}, chamberManager.getLeftWardParticles());
		Assertions.assertArrayEquals(new boolean[] {false, true, false, false, true, false}, chamberManager.getRightWardParticles());
	}	
	
	@Test
	void TestMoveOneStep() {
		ChamberManager chamberManager = new ChamberManager(1, "LR..RL");
		chamberManager.move();		
		String expectedLocation = "..X.XX";		
		String resultLoction = chamberManager.getParticleLocation();		
		Assertions.assertEquals(expectedLocation, resultLoction);
		
		chamberManager.move();		
		String expectedLocation2 = "...X..";		
		String resultLoction2 = chamberManager.getParticleLocation();		
		Assertions.assertEquals(expectedLocation2, resultLoction2);		
	}

	@Test
	void TestMoveFaster() {
		ChamberManager chamberManager = new ChamberManager(2, "LR..RL");
		chamberManager.move();		
		String expectedLocation2 = "...X..";		
		String resultLoction2 = chamberManager.getParticleLocation();		
		Assertions.assertEquals(expectedLocation2, resultLoction2);		
	}	
	
	@Test
	void TestGetParticleLocation() {
		ChamberManager chamberManager = new ChamberManager(1, "LR..RL");
		String expectedLocation = "XX..XX";		
		String resultLoction = chamberManager.getParticleLocation();		
		Assertions.assertEquals(expectedLocation, resultLoction);	
	}	
	
	@Test
	void TestIsChamberEmpty() {
		ChamberManager chamberManager = new ChamberManager(2, ".......");
		Assertions.assertEquals(true, chamberManager.isEmptyChamber());

		chamberManager = new ChamberManager(2, "...R...");
		Assertions.assertEquals(false, chamberManager.isEmptyChamber());	
			
	}
	
	@Test
	void animateCase0() {
		int speed = 2;
		String init = "..R....";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays.asList(new String[] { "..X....", "....X..", "......X", "......." });
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}

	@Test
	void animateCase1() {
		int speed = 3;
		String init = "RR..LRL";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays.asList(new String[] { "XX..XXX", ".X.XX..", "X.....X", "......." });
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}

	@Test
	void animateCase2() {
		int speed = 2;
		String init = "LRLR.LRLR";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays
				.asList(new String[] { "XXXX.XXXX", "X..X.X..X", ".X.X.X.X.", ".X.....X.", "........." });
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}

	@Test
	void animateCase3() {
		int speed = 10;
		String init = "RLRLRLRLRL";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays.asList(new String[] { "XXXXXXXXXX", ".........." });
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}

	@Test
	void animateCase4() {
		int speed = 4;
		String init = "...";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays.asList(new String[] { "..."});
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}
	
	@Test
	void animateCase5() {
		int speed = 1;
		String init = "LRRL.LR.LRR.R.LRRL.";
		ChamberManager chamberManager = new ChamberManager(speed, init);
		List<String> expectedResult = Arrays
				.asList(new String[] { "XXXX.XX.XXX.X.XXXX.", "..XXX..X..XX.X..XX.", ".X.XX.X.X..XX.XX.XX",
						"X.X.XX...X.XXXXX..X", ".X..XXX...X..XX.X..", "X..X..XX.X.XX.XX.X.", "..X....XX..XX..XX.X",
						".X.....XXXX..X..XX.", "X.....X..XX...X..XX", ".....X..X.XX...X..X", "....X..X...XX...X..",
						"...X..X.....XX...X.", "..X..X.......XX...X", ".X..X.........XX...", "X..X...........XX..",
						"..X.............XX.", ".X...............XX", "X.................X", "..................." });
		List<String> actualResults = chamberManager.animate();
		assertEquals(expectedResult, actualResults);
	}	
}

