package com.codecool.app;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorForGameTest {
    private static Card card1 = new Card("Mess", 10, 1, 1, 1, 1, 1);
    private static Card card2 = new Card("Dao", 9, 9, 9, 9, 9, 9);
    private static Card card3 = new Card("Mess", 2, 2, 10, 2, 2, 2);
    private static Card card4 = new Card("Mess", 9, 2, 9, 2, 2, 9);
    private static Comparator comparator = new ComparatorForGame();


    @Test
    void compare() {
        card1.setChoose(0);
        card2.setChoose(0);

        int result = comparator.compare(card1, card2);
        assertEquals(result, 0);
    }

    @Test
    void testCompare() {
        card1.setChoose(2);
        card2.setChoose(2);
        card3.setChoose(2);
    }

    @Test
    void testCompare1() {
    }
}