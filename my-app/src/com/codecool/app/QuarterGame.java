package com.codecool.app;

import java.util.List;

public class QuarterGame {
    private List<Card> deckToGame;
    private int countOfPlayers;

    public QuarterGame(List<Card> deckToGame, int countOfPlayers) {
        this.deckToGame = deckToGame;
        this.countOfPlayers = countOfPlayers;
    }

    void run() {
        System.out.println(this.deckToGame.toString());
        Card card = this.deckToGame.get(0);
        this.deckToGame.remove(this.deckToGame.get(0));
        System.out.println(deckToGame.toString());
        System.out.println(card.toString());
    }
}
