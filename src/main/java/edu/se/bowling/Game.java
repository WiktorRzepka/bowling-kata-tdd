package edu.se.bowling;

public class Game {

    private static final int MAX_NUMBER_OF_ROLLS = 21;
    private static final int NUMBER_OF_PINS = 10;
    private static final int NUMBER_OF_FRAMES = 10;
    private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];
    private int currentRoll = 0;

    public void roll(int pins) {
        if (pins < 0 || pins > NUMBER_OF_PINS){
            throw new IllegalArgumentException("Liczba zbitych kręgli musi być w przedziale 0-10.");
        }
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int result = 0;
        int i = 0;
        for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (isStrike(i)){
                result += 10 + strikeBonus(i);
                i += 1;
            }
            else if (isSpare(i)) {
                result += NUMBER_OF_PINS + spareBonus(i);
                i += 2;
            } else {
                result += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return result;
    }

    private boolean isSpare(int firstRollInFrameIdx) {
        return rolls[firstRollInFrameIdx] + rolls[firstRollInFrameIdx + 1] == NUMBER_OF_PINS;
    }

    private int spareBonus(int firstRollInFrameIdx) {
        return rolls[firstRollInFrameIdx + 2];
    }

    private boolean isStrike(int firstRollInFrameIdx){
        return rolls[firstRollInFrameIdx] == NUMBER_OF_PINS;
    }

    private int strikeBonus(int firstRollInFrameIdx){
        return rolls[firstRollInFrameIdx + 1] + rolls[firstRollInFrameIdx + 2];
    }
}
