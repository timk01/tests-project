package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Dice;
import org.example.DiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

//https://www.vogella.com/tutorials/JUnit/article.html
//https://www.dataset.com/blog/maven-log4j2-project/

class DiceTest {

    Dice dice;
    private static final Logger logger = LogManager.getLogger(DiceTest.class);

    @Before
    void setUp() {
        dice = new DiceImpl();
    }

    @RepeatedTest(10)
    //@Test
    void roll_Positive() {
        int low = 1;
        int high = 6;
        int result = dice.roll();

        logger.info("logger msg of result: " + result);
        //Assertions.assertTrue(result >= low && result <= high, "provided number is out of bounds") ;
        Assertions.assertTrue(result >= low, "provided number is less than 1") ;
        Assertions.assertTrue(result <= high, "provided number is more than 6") ;
    }
}