package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGame {
    private ArrayList<Card> deckToGame;
    private List<Boolean> isUser;
    private ArrayList<Player> players = new ArrayList<>();

    public QuarterGame(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        this.deckToGame = deckToGame;
        this.isUser = isUser;
    }

    void run(QuarterGame game, View view, Scanner scan) {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        ArrayList<Card> deckFirstPlayer = new ArrayList<>();
        ArrayList<Card> deckSecondPlayer = new ArrayList<>();
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
            decks.add(deckFirstPlayer);
            decks.add(deckSecondPlayer);
        }
        game.getPlayersObject(decks, view, scan);

        for (Player player : this.players) {
            System.out.println(player.toString());
        }

        this.players.clear();
        this.isUser.clear();
        this.deckToGame.clear();
    }

    private void getPlayersObject(ArrayList<ArrayList<Card>> decks, View view, Scanner scan) {
        for (int index = 0; index < isUser.size(); index++) {
            if (isUser.get(index)) {
                view.print("Provide your name: ");
                String name = scan.nextLine();
                this.players.add(new UserPlayer(name, decks.get(index)));
            }
            else {
                String name = String.format("enemy%d", index + 1);
                this.players.add(new ComputerPlayer(name, decks.get(index)));
            }
        }
    }
}
