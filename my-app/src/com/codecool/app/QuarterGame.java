package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGame {
    protected ArrayList<Card> deckToGame;
    protected List<Boolean> isUser;
    protected ArrayList<Player> players = new ArrayList<>();
    int chooseToComare;

    public QuarterGame(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        this.deckToGame = deckToGame;
        this.isUser = isUser;
    }

    void run(QuarterGame game, View view, Scanner scan) {
        ArrayList<ArrayList<Card>> separatedDeck = game.getCardsForPlayers(deckToGame);
        game.getPlayersObject(view, scan, separatedDeck);
        game.quarter(view, game);

        this.players.clear();
        this.isUser.clear();
        this.deckToGame.clear();
    }

    protected void getPlayersObject(View view, Scanner scan, ArrayList<ArrayList<Card>> separatedDeck) {
        for (int index = 0; index < isUser.size(); index++) {
            if (isUser.get(index)) {
                view.print("Provide your name: ");
                String name = scan.nextLine();
                this.players.add(new UserPlayer(name, separatedDeck.get(index)));
            }
            else {
                String name = String.format("Enemy%d", index + 1);
                this.players.add(new ComputerPlayer(name, separatedDeck.get(index)));
            }
        }
    }

    protected ArrayList<ArrayList<Card>> getCardsForPlayers(ArrayList<Card> deckToGame) {
        ArrayList<ArrayList<Card>> separatedDeck = new ArrayList<>();

        for (int i = 0; i < isUser.size(); i++) {
            ArrayList<Card> bufforList = new ArrayList<>();

            for (int j = 0; j < this.deckToGame.size()/isUser.size(); j++) {
                bufforList.add(deckToGame.get(i * this.deckToGame.size()/isUser.size() + j));
            }
            separatedDeck.add(bufforList);
        }
        return separatedDeck;
    }

    protected void quarter(View view, QuarterGame game) {
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
                    game.quantityCardsOfPlayers(view);
                    view.println(String.format("%s are choosing", players.get(0).getName()));
                    this.chooseToComare = players.get(0).chooseCardField();
                }
                else {
                    view.println(String.format("%s win battle", players.get(1).getName()));
                    game.quantityCardsOfPlayers(view);
                    view.println(String.format("%s are choosing", players.get(1).getName()));
                    this.chooseToComare = players.get(1).chooseCardField();
                }
            }
            else {
                view.println("Draw");
                game.quantityCardsOfPlayers(view);
            }
        }

        if (this.players.get(0).hasNext()) {
            view.println(String.format("%s win game!!!", players.get(0).getName()));
        }
        else {
            view.println(String.format("%s win game!!!", players.get(1).getName()));
        }
    }

    protected void quantityCardsOfPlayers(View view) {
        view.println(String.format("%s has %d Card's", this.players.get(0).getName(), this.players.get(0).getCards().size()));
        view.println(String.format("%s has %d Card's", this.players.get(1).getName(), this.players.get(1).getCards().size()));
    }
}
