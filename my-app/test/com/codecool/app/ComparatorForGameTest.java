package com.codecool.app;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorForGameTest {
    private Card card1 = new Card("Mess", 10, 1, 1, 1, 1, 1);
    private Card card2 = new Card("Dao", 9, 9, 9, 9, 9, 9);
    private Card card3 = new Card("Mess", 2, 2, 10, 2, 2, 2);
    private Card card4 = new Card("Mess", 9, 2, 9, 2, 2, 9);
    private Comparator comparator = new ComparatorForGame();


    @Test
    void compareTwoCard_firstWin() {
        card1.setChoose(0);
        card2.setChoose(0);

        int result = comparator.compare(card1, card2);
        assertEquals(result, 0);
    }

    @Test
    void compareTwoCard_secondWin() {
        card2.setChoose(2);
        card3.setChoose(2);

        int result = comparator.compare(card2, card3);
        assertEquals(result, 1);

    }

    @Test
    void compareTwoCard_Draw() {
        card3.setChoose(4);
        card4.setChoose(4);

        int result = comparator.compare(card3, card4);
        assertEquals(result, 4);
    }
}