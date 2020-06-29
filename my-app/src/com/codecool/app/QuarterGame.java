package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGame {
    private ArrayList<Card> deckToGame;
    private List<Boolean> isUser;
    private ArrayList<Player> players = new ArrayList<>();
    int chooseToComare;

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
        game.quarter(view);

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
                String name = String.format("Enemy%d", index + 1);
                this.players.add(new ComputerPlayer(name, decks.get(index)));
            }
        }
    }

    private void quarter(View view) {
        ArrayList<Card> cardsInBuffer =  new ArrayList<>();
        ArrayList<Card> cartsToCompare =  new ArrayList<>();
        ComparatorForGame comparator = new ComparatorForGame();
        view.println(String.format("%s are choosing", players.get(0).getName()));
        this.chooseToComare = players.get(0).chooseCardField();

        while (this.players.get(0).hasNext() && this.players.get(1).hasNext()) {
            int result = 0;

            for (Player player : this.players) {
                if (player.hasNext()) {
                    player.getCards().get(0).setChoose(this.chooseToComare);
                    cartsToCompare.add(player.next());
                }
            }

            result = comparator.compare(cartsToCompare.get(0), cartsToCompare.get(1));
            cardsInBuffer.addAll(cartsToCompare);
            cartsToCompare.clear();

            if (result == 0 || result == 1) {
                this.players.get(result).getCards().addAll(cardsInBuffer);
                cardsInBuffer.clear();

                if (result == 0) {
                    view.println(String.format("%s win battle", players.get(0).getName()));
                    view.println(String.format("%s are choosing", players.get(0).getName()));
                    this.chooseToComare = players.get(0).chooseCardField();
                }
                else {
                    view.println(String.format("%s win battle", players.get(1).getName()));
                    view.println(String.format("%s are choosing", players.get(1).getName()));
                    this.chooseToComare = players.get(1).chooseCardField();
                }
            }
            else {
                view.println("Draw");
            }
        }

        if (this.players.get(0).hasNext()) {
            view.println(String.format("%s win game!!!", players.get(0).getName()));
        }
        else {
            view.println(String.format("%s win game!!!", players.get(1).getName()));
        }
    }

    public int getChooseToComare() {
        return chooseToComare;
    }
}
