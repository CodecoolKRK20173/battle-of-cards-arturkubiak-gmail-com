package com.codecool.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private static Card card1 = new Card("Mess", 1, 2, 3, 4, 5, 6);

    private static Card card2 = new Card("Mess", 1, 1, 1, 1, 1, 1);

    @Test
    void testChooseCardFieldBiggestField(){
        List<Card> player1Cards = new ArrayList<>(); player1Cards.add(card1);
        Player player1 = new ComputerPlayer("player1", (ArrayList<Card>) player1Cards);

        int choosenField = player1.chooseCardField()+1;
        assertEquals(choosenField, 6);
    }

    @Test
    void testChooseCardFieldBiggestEaqulField(){
        List<Card> player2Cards = new ArrayList<>(); player2Cards.add(card2);
        Player player2 = new ComputerPlayer("player2", (ArrayList<Card>) player2Cards);
        // fifthRate = 1.3 is actual the biggest rate in card;
        int choosenField = player2.chooseCardField()+1;
        assertEquals(choosenField, 5);
    }

}