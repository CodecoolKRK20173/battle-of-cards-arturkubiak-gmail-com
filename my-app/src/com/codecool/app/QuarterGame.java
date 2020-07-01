package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGame {
    protected ArrayList<Card> deckToGame;
    protected List<Boolean> isUser;
    protected ArrayList<Player> players = new ArrayList<>();
    protected ArrayList<Card> cardsInBuffer =  new ArrayList<>();
    protected ArrayList<Card> cartsToCompare =  new ArrayList<>();
    protected ArrayList<Player> playersInGame = new ArrayList<>();
    protected int chooseToComare;
    protected int result = 0;

    public QuarterGame(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        this.deckToGame = deckToGame;
        this.isUser = isUser;
    }

    void run(QuarterGame game, View view, Scanner scan) {
        ArrayList<ArrayList<Card>> separatedDeck = game.getCardsForPlayers(deckToGame);
        game.getPlayersObject(view, scan, separatedDeck);

        view.println(String.format("%s are choosing", players.get(0).getName()));
        this.chooseToComare = players.get(0).chooseCardField();
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
        ComparatorForGame comparator = new ComparatorForGame();

        if (players.size() == 2) {
            while (areEnoughPlayers()) {
                game.presEnter(view);

                for (Player player : this.players) {
                    if (player.hasNext()) {
                        player.getCards().get(0).setChoose(this.chooseToComare);
                        this.cartsToCompare.add(player.next());
                        this.playersInGame.add(player);
                    }
                }

                this.result = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
                this.cardsInBuffer.addAll(this.cartsToCompare);
                this.cartsToCompare.clear();

                if (this.result == 0 || this.result == 1) {
                    this.players.get(this.result).getCards().addAll(this.cardsInBuffer);
                    this.cardsInBuffer.clear();
                    game.getChooseAfterWin(view, game);
                } else {
                    view.println("Draw");
                    game.quantityCardsOfPlayers(view);
                }
                this.playersInGame.clear();
            }
        }
        if (this.players.get(0).hasNext()) {
            view.println(String.format("%s win game!!!", players.get(0).getName()));
        } else {
            view.println(String.format("%s win game!!!", players.get(1).getName()));
        }
    }

    protected void presEnter(View view) {
        Scanner scan = new Scanner(System.in);
        view.println("Press ENTER");
        String pressing = scan.nextLine();
    }

    protected boolean areEnoughPlayers() {

        for (Player player : this.players) {
            if (!player.hasNext()) {
                return false;
            }
        }
        return true;
    }

    protected void getChooseAfterWin(View view, QuarterGame game) {
        view.println(String.format("%s win battle", players.get(this.result).getName()));
        game.quantityCardsOfPlayers(view);
        view.println(String.format("%s are choosing", players.get(this.result).getName()));
        this.chooseToComare = players.get(result).chooseCardField();
    }

    protected void quantityCardsOfPlayers(View view) {
        for (Player player : this.players) {
            view.println(String.format("%s has %d Card's", player.getName(), player.getCards().size()));
        }
    }
}
