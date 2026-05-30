package edu.se.bowling;

public class Game {

    private static final int MAX_NUMBER_OF_ROLLS = 21;
    private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int result = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[i] + rolls[i + 1] == 10) {
                result += 10 + rolls[i + 2];
                i += 2;
            } else {
                result += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return result;
    }
}
