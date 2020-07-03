package com.codecool.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorForGameTest {
    private Card card1 = new Card("Mess", 10, 1, 1, 1, 1, 2);
    private Card card2 = new Card("Dao", 8, 9, 9, 9, 9, 9);
    private Card card3 = new Card("Mess", 2, 2, 10, 2, 2, 2);
    private Card card4 = new Card("Mess", 9, 2, 2, 2, 2, 9);
    private Comparator comparator = new ComparatorForGame();


    @Test
    void compareTwoCard_firstWin() {
        card1.setChoose(0);
        card2.setChoose(0);
        card3.setChoose(0);
        card4.setChoose(0);

        assertAll((Executable) () -> assertEquals(0, comparator.compare(card1, card2)),
                (Executable) () -> assertEquals(0, comparator.compare(card2, card3)),
                (Executable) () -> assertEquals(0, comparator.compare(card2, card3)),
                (Executable) () -> assertEquals(0, comparator.compare(card4, card2)));
    }

    @Test
    void compareTwoCard_secondWin() {
        card1.setChoose(2);
        card2.setChoose(2);
        card3.setChoose(2);
        card4.setChoose(2);

        assertAll((Executable) () -> assertEquals(1, comparator.compare(card1, card2)),
                (Executable) () -> assertEquals(1, comparator.compare(card2, card3)),
                (Executable) () -> assertEquals(1, comparator.compare(card1, card4)),
                (Executable) () -> assertEquals(1, comparator.compare(card1, card3)));
    }

    @Test
    void compareTwoCard_Draw() {
        card1.setChoose(5);
        card2.setChoose(5);
        card3.setChoose(5);
        card4.setChoose(5);

        assertAll((Executable) () -> assertEquals(4, comparator.compare(card1, card3)),
                (Executable) () -> assertEquals(4, comparator.compare(card2, card4)),
                (Executable) () -> assertNotEquals(4, comparator.compare(card1, card4)),
                (Executable) () -> assertNotEquals(1, comparator.compare(card2, card3)));
    }
}