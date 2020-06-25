package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGame {
    private List<Card> deckToGame;
    private int countOfPlayers;

    public QuarterGame(List<Card> deckToGame, int countOfPlayers) {
        this.deckToGame = deckToGame;
        this.countOfPlayers = countOfPlayers;
    }

    void run() {
        List<Card> deckFirstPlayer = new ArrayList<>();
        List<Card> deckSecondPlayer = new ArrayList<>();
        int sizeOfDeck = deckToGame.size();

        for (int index = 0; index < sizeOfDeck; index++) {
            Card card = this.deckToGame.get(0);
            this.deckToGame.remove(this.deckToGame.get(0));

            if (index % 2 == 0) {
                deckFirstPlayer.add(card);
            }
            else {
                deckSecondPlayer.add(card);
            }
        }
        System.out.println(deckFirstPlayer.toString());
        System.out.println(deckFirstPlayer.size());
        System.out.println(deckSecondPlayer.toString());
        System.out.println(deckSecondPlayer.size());
    }
}
