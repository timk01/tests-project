package org.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class) //check 5 junit @runwith replacement
public class GameTest {

    @Mock
    private Dice dice;

    @Mock
    private WInnerPrinter wInnerPrinter;

    private Game game;

    @Before
    public void setUp() {
        game = new Game(dice, wInnerPrinter);
        //dice = Mockito.mock(Dice.class); //without @Mock
    }

    @org.junit.Test
    public void testPlayerOneWin() {
        Mockito.when(dice.roll()).thenReturn(6, 5);

        doAnswer(answer -> {
            String message = answer.getArgument(0, String.class);
            assertEquals("Player 1 win", message);
            return null;
        })
                .when(wInnerPrinter).print(any(String.class));

        game.playGame();
    }

    @org.junit.Test
    public void testPlayerTwoWin() {
        Mockito.when(dice.roll()).thenReturn(5, 6);

        doAnswer(answer -> {
            String message = answer.getArgument(0, String.class);
            assertEquals("Player 2 win", message);
            return null;
        })
                .when(wInnerPrinter).print(any(String.class));

        game.playGame();
    }

    @org.junit.Test
    public void testNobodyWins() {
        Mockito.when(dice.roll()).thenReturn(6, 6);

        doAnswer(answer -> {
            String message = answer.getArgument(0, String.class);
            assertEquals("Nobody", message);
            return null;
        })
                .when(wInnerPrinter).print(any(String.class));

        //doNothing();

        game.playGame();

        doAnswer(answer -> {
            Integer theNumber = answer.getArgument(0, Integer.class);
            String[] arrayString = answer.getArgument(1, String[].class);
            //assertEquals("Nobody", message);
            return null;
        })
                .when(wInnerPrinter).calcuateThree(any(Integer.class),any(String[].class));

    }
}

//jakoko ? to see coverage