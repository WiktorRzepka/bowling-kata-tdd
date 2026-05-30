package edu.se.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
}
