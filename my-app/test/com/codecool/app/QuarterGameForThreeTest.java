package com.codecool.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class QuarterGameForThreeTest {

    private View view = new View();;
    private List<Boolean> isUser = new ArrayList<>(Arrays.asList(true, false, true));
    private Scanner scan = new Scanner(System.in);

    private Card card1 = new Card("L. Messi",87,92,92,96,39,66);
    private Card card2 = new Card("C. Ronaldo",90,93,82,89,35,78);
    private Card card3 = new Card("R. Lewandowski",77,87,74,85,41,82);
    private ArrayList<Card> deckOfCards = new ArrayList<>(Arrays.asList(card1, card2, card3));

    private Player player = new ComputerPlayer("Adam", deckOfCards);
    private Player player2 = new ComputerPlayer("Robert", deckOfCards);
    private Player player3 = new ComputerPlayer("Piotr", deckOfCards);

    private QuarterGameForThree game = new QuarterGameForThree(deckOfCards, isUser, view);


    @Test
    void shouldAddCardsToCompareIfDraw() {
        game.players = new ArrayList<>(Arrays.asList(player, player2, player3));
        game.chooseToComare = 1;
        game.addCardsToCompareIfDraw(5);

        assertAll((Executable) () -> assertEquals(2, game.playersInGame.size()),
                (Executable) () -> assertEquals("C. Ronaldo", game.cartsToCompare.get(1).getName()),
                (Executable) () -> assertEquals(92, game.cartsToCompare.get(0).getAtribute(game.chooseToComare)));
    }

    @Test
    void shouldAddCartsToPlayers() {

        this.player.getCards().add(card3);

        assertEquals(4, this.player.getCards().size());
    }

    @Test
    void shouldGetCompareResult() {
        game.result = 4;
        card1.setChoose(1);
        card2.setChoose(1);
        game.cartsToCompare = new ArrayList<>(Arrays.asList(card1, card2));
        game.getCompareResult();
        assertEquals(1, game.result);
    }

    @Test
    void shouldRemovePlayer() {
        game.players = new ArrayList<>(Arrays.asList(player, player2, player3));

        int count = game.players.get(1).getCards().size();

        for (int i = 0; i < count; i++) {
            String x = game.players.get(0).getCards().toString();
            game.players.get(1).next();
        }
        String x = game.players.get(1).getCards().toString();
        game.removePlayer();

        assertEquals(0, game.players.size());
    }
}