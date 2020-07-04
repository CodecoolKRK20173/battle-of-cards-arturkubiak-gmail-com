package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForThree extends QuarterGame {

    public QuarterGameForThree(ArrayList<Card> deckToGame, List<Boolean> isUser, View view) {
        super(deckToGame, isUser, view);
    }

    @Override
    protected void quarter() {

        while (this.players.size() == 3) {
            view.pressEnter();

            if (this.result == 0 || this.result == 1 || this.result == 2 || this.result == 10) {
                for (Player player : this.players) {
                    player.getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(player.next());
                    this.playersInGame.add(player);
                }
            }
            else {
                addCardsToCompareIfDraw(this.result);
            }
            getCompareResult();
            addCartsToPlayers();
            removePlayer();
        }
        afterBreakLoop();
    }

    protected void addCardsToCompareIfDraw(int result) {
        int []tab;

        if (result == 4) {
            tab = new int[]{0, 1};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        } else if (result == 5) {
            tab = new int[] {0, 2};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        } else {
            tab = new int[]{1, 2};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
    }

    protected void addCartsToPlayers() {
        this.cardsInBuffer.addAll(this.cartsToCompare);
        this.cartsToCompare.clear();

        if (result == 0 || result == 1 || result == 2 || result == 3) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        showResultWithCompare(this.result);
        this.playersInGame.clear();
    }

    protected void showResultWithCompare(int result) {
        if (result == 0 || result == 1 || result == 2) {
            this.cardsInBuffer.clear();
            getChooseAfterWin();
        }
        else {
            if (result == 4) {
                view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(1).getName()));
            }
            else if (result == 5) {
                view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(2).getName()));
            }
            else if (result == 7) {
                view.println(String.format("Draw! %s and %s", players.get(1).getName(), players.get(2).getName()));
            }
            else {
                view.println("Draw! All players");
            }
            quantityCardsOfPlayers();
        }
    }

    protected void getCompareResult() {
        ComparatorForGame comparator = new ComparatorForGame();
        int bufforResult = 0;

        if (this.cartsToCompare.size() == 3) {
            this.result = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1), this.cartsToCompare.get(2));
        }
        else {
            bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
        }

        if (bufforResult == 0 && this.result == 4) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 4) {
            this.result = 1;
        }
        else if (bufforResult == 0 && this.result == 5) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 5) {
            this.result = 2;
        }
        else if (bufforResult == 0 && this.result == 7) {
            this.result = 1;
        }
        else if (bufforResult == 1 && this.result == 7) {
            this.result = 2;
        }
    }

    protected void afterBreakLoop() {
        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter();
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
