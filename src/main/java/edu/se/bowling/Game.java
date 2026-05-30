package edu.se.bowling;

public class Game {

    private static final int MAX_NUMBER_OF_ROLLS = 21;
    private static final int NUMBER_OF_PINS = 10;
    private static final int NUMBER_OF_FRAMES = 10;
    private static final int FIRST_NINE_FRAMES_MAX_ROLLS = 18;
    private int[] rolls = new int[MAX_NUMBER_OF_ROLLS];
    private int currentRoll = 0;

    public void roll(int pins) {
        validatePinsCount(pins);

        if (isGameOver()) {
            throw new IllegalStateException("Gra została już zakończona. Nie można wykonać więcej rzutów.");
        }

        if (isSecondRollInNormalFrame()) {
            validateFrameTotalPins(pins);
        }

        rolls[currentRoll++] = pins;
    }

    public int score() {
        int result = 0;
        int i = 0;
        for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (isStrike(i)){
                result += NUMBER_OF_PINS + strikeBonus(i);
                i += 1;
            }
            else if (isSpare(i)) {
                result += NUMBER_OF_PINS + spareBonus(i);
                i += 2;
            } else {
                result += sumOfBallsInFrame(i);
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

    private int sumOfBallsInFrame(int firstRollInFrameIdx) {
        return rolls[firstRollInFrameIdx] + rolls[firstRollInFrameIdx + 1];
    }

    private boolean isSecondRollInNormalFrame() {
        return currentRoll % 2 == 1 && rolls[currentRoll - 1] != NUMBER_OF_PINS && currentRoll < FIRST_NINE_FRAMES_MAX_ROLLS;
    }

    private void validateFrameTotalPins(int pins) {
        if (rolls[currentRoll - 1] + pins > NUMBER_OF_PINS) {
            throw new IllegalArgumentException("Suma kręgli w jednej ramce nie może przekraczać 10.");
        }
    }

    private void validatePinsCount(int pins) {
        if (pins < 0 || pins > NUMBER_OF_PINS){
            throw new IllegalArgumentException("Liczba zbitych kręgli musi być w przedziale 0-10.");
        }
    }

    private boolean isGameOver() {
        int idx = 0;

        for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (idx >= currentRoll) {
                return false;
            }

            if (rolls[idx] == NUMBER_OF_PINS) {
                idx += 1;
            } else {
                if (idx + 1 >= currentRoll) {
                    return false;
                }
                idx += 2;
            }
        }

        if (rolls[idx - 1] == NUMBER_OF_PINS) {
            return currentRoll >= idx + 2;
        }
        else if (rolls[idx - 2] + rolls[idx - 1] == NUMBER_OF_PINS) {
            return currentRoll >= idx + 1;
        }
        else {
            return currentRoll >= idx;
        }
    }
}
