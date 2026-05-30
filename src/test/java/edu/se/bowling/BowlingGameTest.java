package edu.se.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {
	private Game game;

	@BeforeEach
	public void setUp() throws Exception {
		game = new Game();
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}

	private void rollSpare(){
		game.roll(5);
		game.roll(5);
	}

	@Test
	public void testGutterGame() {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	@Test
	void testOneSpare() {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}

	@Test
	void testOneStrike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}

	@Test
	void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

	@Test
	void testNegativePinsShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
	}

	@Test
	void testMoreThan10PinsInSingleRollShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> game.roll(11));
	}

	@Test
	void testMoreThan10PinsInFrameShouldThrowException() {
		game.roll(6);
		assertThrows(IllegalArgumentException.class, () -> game.roll(5));
	}
}
