package edu.se.bowling;

public class Game {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int result = 0;
        return result;
    }
}
