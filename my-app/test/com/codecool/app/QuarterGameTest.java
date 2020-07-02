package com.codecool.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuarterGameTest {

    private static Card card1 = new Card("Mess", 1, 1, 1, 1, 1, 1);
    private static Card card2 = new Card("Dao", 3, 3, 3, 3, 3, 3);
    private static Card card3 = new Card("Mess", 5, 5, 5, 5, 5, 5);
    private static Card card4 = new Card("Mess", 5, 5, 5, 5, 5, 5);

    private static boolean player1IsUser = true;
    private static boolean player2IsUser = false;

    private static ArrayList<Boolean> playerListIsUser = new ArrayList();
    private static ArrayList<Card> fullDeck = new ArrayList();

    private static QuarterGame quarterGame;
    private static ArrayList<Player> players = new ArrayList<>();

    private static View view = new View();

    QuarterGameTest(){
        fullDeck.add(card1); fullDeck.add(card2); fullDeck.add(card3); fullDeck.add(card4);
        playerListIsUser.add(player1IsUser); playerListIsUser.add(player2IsUser);

        quarterGame = new QuarterGame(fullDeck, playerListIsUser);

    }

    @Test
    void testGetCardsForPlayers() {

        for (List<Card> playerDeck : quarterGame.getCardsForPlayers(fullDeck)) {
            assertEquals(playerDeck.size(), 2);
        }
    }

    @Test
    void testQuarterPlayer1Win(){
        quarterGame.players.clear();

        List<Card> player1Cards = new ArrayList<>(); player1Cards.add(card2);
        Player player1 = new ComputerPlayer("player1", (ArrayList<Card>) player1Cards); quarterGame.players.add(player1);

        List<Card> player2Cards = new ArrayList<>(); player2Cards.add(card1);
        Player player2 = new ComputerPlayer("player2", (ArrayList<Card>) player2Cards); quarterGame.players.add(player2);

        assertEquals(quarterGame.players.size(), 2);
        quarterGame.quarter(view, quarterGame);

        assertEquals(player1.Cards.size(), 2);
        assertEquals(player2.Cards.size(), 0);
    }

    @Test
    void testQuarterPlayer2Win(){
        quarterGame.players.clear();

        List<Card> player1Cards = new ArrayList<>(); player1Cards.add(card1);
        Player player1 = new ComputerPlayer("player1", (ArrayList<Card>) player1Cards); quarterGame.players.add(player1);

        List<Card> player2Cards = new ArrayList<>(); player2Cards.add(card2);
        Player player2 = new ComputerPlayer("player2", (ArrayList<Card>) player2Cards); quarterGame.players.add(player2);

        assertEquals(quarterGame.players.size(), 2);
        quarterGame.quarter(view, quarterGame);

        assertEquals(player1.Cards.size(), 0);
        assertEquals(player2.Cards.size(), 2);
    }

    @Test
    void testQuarterPlayerDrow(){
        quarterGame.players.clear();

        List<Card> player1Cards = new ArrayList<>(); player1Cards.add(card1); player1Cards.add(card1);
        Player player1 = new ComputerPlayer("player1", (ArrayList<Card>) player1Cards); quarterGame.players.add(player1);

        List<Card> player2Cards = new ArrayList<>(); player2Cards.add(card1); player2Cards.add(card2);
        Player player2 = new ComputerPlayer("player2", (ArrayList<Card>) player2Cards); quarterGame.players.add(player2);

        assertEquals(quarterGame.players.size(), 2);
        quarterGame.quarter(view, quarterGame);

        assertEquals(player1.Cards.size(), 0);
        assertEquals(player2.Cards.size(), 4);
    }

}