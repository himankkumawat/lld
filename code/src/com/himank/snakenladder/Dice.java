package com.himank.snakenladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceCount;
    private int min = 1, max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int diceRolled = 0;
        int sum = 0;
        while (diceRolled < diceCount) {
            sum += ThreadLocalRandom.current().nextInt(min, max + 1);
            diceRolled++;
        }
        return sum;
    }
}
