package org.example;

public class Game {
    private Dice dice;
    private WInnerPrinter printer;

    public Game(Dice dice, WInnerPrinter printer) {
        this.dice = dice;
        this.printer = printer;
    }

    public void playGame() {
        int result1 = dice.roll();
        int result2 = dice.roll();
        if (result1 > result2) {
            printer.print("Player 1 win");
        } else if (result1 < result2) {
            printer.print("Player 2 win");
        } else {
            printer.print("Nobody");
        }
    }
}
