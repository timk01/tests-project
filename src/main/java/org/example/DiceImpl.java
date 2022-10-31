package org.example;

import java.util.Random;

public class DiceImpl implements Dice{

    private final static int MIN = 1;
    private final static int MAX = 6;
    Random random;

    public DiceImpl() {
        random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(MAX) + MIN;
    }
}
