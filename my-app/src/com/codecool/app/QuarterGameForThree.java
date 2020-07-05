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

            if (this.result == FightResult.FIRST_WIN.ordinal()) {addCartFromAllPlayers(); }
            else if (this.result == FightResult.SECOND_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.THIRD_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.WAR_1_2_3.ordinal()) { addCartFromAllPlayers(); }
            else { addCardsToCompareIfDraw(this.result); }

            getCompareResult();
            addCartsToPlayers();
            removePlayer();
        }
        afterBreakLoop();
    }

    protected void addCardsToCompareIfDraw(int result) {
        int [] tabWithPlayersInGame;

        if (result == FightResult.WAR_1_2.ordinal()) {
            tabWithPlayersInGame = new int[] {0, 1};
        } else if (result == FightResult.WAR_1_3.ordinal()) {
            tabWithPlayersInGame = new int[] {0, 2};
        } else {
            tabWithPlayersInGame = new int[] {1, 2};
        }
        for (int value : tabWithPlayersInGame) {
            this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
            this.playersInGame.add(players.get(value));
            this.cartsToCompare.add(this.players.get(value).next());
        }
    }

    protected void addCartsToPlayers() {
        this.cardsInBuffer.addAll(this.cartsToCompare);
        this.cartsToCompare.clear();

        if (result == FightResult.FIRST_WIN.ordinal()) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        else if (result == FightResult.SECOND_WIN.ordinal()) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        else if (result == FightResult.THIRD_WIN.ordinal()) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        else if (result == FightResult.FOURTH_WIN.ordinal()) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        showResultWithCompare(this.result);
        this.playersInGame.clear();
    }

    protected void showResultWithCompare(int result) {
        if (result == FightResult.FIRST_WIN.ordinal()) {
            getChooseAfterWin();
        }
        else if (result == FightResult.SECOND_WIN.ordinal()) {
            getChooseAfterWin();
        }
        else if (result == FightResult.THIRD_WIN.ordinal()) {
            getChooseAfterWin();
        }
        else {
            if (result == FightResult.WAR_1_2.ordinal()) {
                view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(1).getName()));
            }
            else if (result == FightResult.WAR_1_3.ordinal()) {
                view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(2).getName()));
            }
            else if (result == FightResult.WAR_2_3.ordinal()) {
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

        if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_2.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_2.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_3.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_3.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_2_3.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_2_3.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
    }

    protected void afterBreakLoop() {
        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter();
    }
}
