package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGame {
    protected ArrayList<Card> deckToGame;
    protected List<Boolean> isUser;
    protected View view;
    protected ArrayList<Player> players = new ArrayList<>();
    protected ArrayList<Card> cardsInBuffer =  new ArrayList<>();
    protected ArrayList<Card> cartsToCompare =  new ArrayList<>();
    protected ArrayList<Player> playersInGame = new ArrayList<>();
    protected int chooseToComare;
    protected int result = 0;

    public QuarterGame(ArrayList<Card> deckToGame, List<Boolean> isUser, View view) {
        this.view = view;
        this.deckToGame = deckToGame;
        this.isUser = isUser;
    }

    void run() {
        ArrayList<ArrayList<Card>> separatedDeck = getCardsForPlayers(deckToGame);
        getPlayersObject(separatedDeck);
        this.chooseToComare = players.get(0).chooseCardField();
        quarter();

        this.players.clear();
        this.isUser.clear();
        this.deckToGame.clear();
    }

    protected void getPlayersObject(ArrayList<ArrayList<Card>> separatedDeck) {
        for (int index = 0; index < isUser.size(); index++) {
            if (isUser.get(index)) {
                String name = view.getNamePlayer();
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

    protected void quarter() {
        ComparatorForGame comparator = new ComparatorForGame();

        while (players.size() == 2) {
            view.pressEnter();
            addCartFromAllPlayers();
            this.result = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));

            ArrayList<Card> lastUsedCards = new ArrayList<>();
            for (Card card : cartsToCompare) {
                lastUsedCards.add(card);
            }

            this.cardsInBuffer.addAll(this.cartsToCompare);
            this.cartsToCompare.clear();
            showResultAfterRound(lastUsedCards);
            this.playersInGame.clear();
            removePlayer();
        }
        if (this.players.get(0).hasNext()) {
            view.println(String.format("%s win game!!!", players.get(0).getName()));
        } else {
            view.println(String.format("%s win game!!!", players.get(1).getName()));
        }
    }

    protected void addCartFromAllPlayers() {
        for (Player player : this.players) {
            if (player.hasNext()) {
                player.getCards().get(0).setChoose(this.chooseToComare);
                this.cartsToCompare.add(player.next());
                this.playersInGame.add(player);
            }
        }
    }

    protected void showResultAfterRound(ArrayList<Card> lastUsedCards) {
        if (this.result == FightResult.FIRST_WIN.ordinal() || this.result == FightResult.SECOND_WIN.ordinal()) {
            this.players.get(this.result).getCards().addAll(this.cardsInBuffer);

            if(playersInGame.size() > 1) {
                GameBoard gameBoard = new GameBoard();
                view.clearScreen();
                PrintBoard newPrint = new PrintBoard(gameBoard.createFullBoard(playersInGame, lastUsedCards));
                newPrint.displayBoard();
            }
            getChooseAfterWin();
        } else {
            if(playersInGame.size() > 1) {
                GameBoard gameBoard = new GameBoard();
                view.clearScreen();
                PrintBoard newPrint = new PrintBoard(gameBoard.createFullBoard(playersInGame, lastUsedCards));
                newPrint.displayBoard();
            }
            view.println("Draw");
        }
    }

    protected void getChooseAfterWin() {
        this.cardsInBuffer.clear();
        view.println(String.format("%s wins battle", players.get(this.result).getName()));
        System.out.println(" ");
        view.println(String.format("%s, pick statistic you want to play:", players.get(this.result).getName()));

        this.chooseToComare = players.get(result).chooseCardField();
    }

    protected void quantityCardsOfPlayers() {
        for (Player player : this.players) {
            view.println(String.format("%s has %d Card's", player.getName(), player.getCards().size()));
        }
    }

    protected void removePlayer() {
        ArrayList<Player> bufforPlayers = new ArrayList<>();

        for (Player player : this.players) {
            if (player.hasNext()) {
                bufforPlayers.add(player);
            }
        }
        this.players.clear();
        this.players.addAll(bufforPlayers);
    }
}

