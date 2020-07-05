package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForFour extends QuarterGameForThree {

    public QuarterGameForFour(ArrayList<Card> deckToGame, List<Boolean> isUser, View view) {
        super(deckToGame, isUser, view);
    }

    @Override
    protected void quarter() {

        while (this.players.size() == 4) {
            view.pressEnter();

            if (this.result == FightResult.FIRST_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.SECOND_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.THIRD_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.FOURTH_WIN.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.WAR_1_2_3_4.ordinal()) { addCartFromAllPlayers(); }
            else if (this.result == FightResult.WAR_1_2.ordinal()) { super.addCardsToCompareIfDraw(this.result); }
            else if (this.result == FightResult.WAR_1_3.ordinal()) { super.addCardsToCompareIfDraw(this.result); }
            else if (this.result == FightResult.WAR_2_3.ordinal()) { super.addCardsToCompareIfDraw(this.result); }
            else { addCardsToCompareIfDraw(this.result); }

            getCompareResult();
            addCartsToPlayers();
            removePlayer();
        }

        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter();
    }

    @Override
    protected void addCardsToCompareIfDraw(int result) {
        int []tabWithPlayersInGame;

        if (result == FightResult.WAR_1_4.ordinal()) {
            tabWithPlayersInGame = new int[]{0, 3};
        }
        else if (result == FightResult.WAR_2_4.ordinal()) {
            tabWithPlayersInGame = new int[] {1, 3};
        }
        else if (result == FightResult.WAR_3_4.ordinal()) {
            tabWithPlayersInGame = new int[] {2, 3};
        }
        else if (result == FightResult.WAR_1_2_3.ordinal()) {
            tabWithPlayersInGame = new int[] {0, 1, 2};
        }
        else if (result == FightResult.WAR_1_2_4.ordinal()) {
            tabWithPlayersInGame = new int[] {0, 1, 3};
        }
        else if (result == FightResult.WAR_1_3_4.ordinal()) {
            tabWithPlayersInGame = new int[] {0, 2, 3};
        }
        else {
            tabWithPlayersInGame = new int[] {1, 2, 3};
        }
        for (int value : tabWithPlayersInGame) {
            this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
            this.playersInGame.add(players.get(value));
            this.cartsToCompare.add(this.players.get(value).next());
        }

    }

    @Override
    protected void getCompareResult() {
        ComparatorForGame comparator = new ComparatorForGame();
        int bufforResult = 0;

        if (this.cartsToCompare.size() == 4) {
            this.result = comparator.compare(this.cartsToCompare.get(0),
                                             this.cartsToCompare.get(1),
                                             this.cartsToCompare.get(2),
                                             this.cartsToCompare.get(3));
        }
        else {
            if (this.result == FightResult.WAR_1_2.ordinal()) {
                super.getCompareResult();
            }
            else if (this.result == FightResult.WAR_1_3.ordinal()) {
                super.getCompareResult();
            }
            else if (this.result == FightResult.WAR_2_3.ordinal()) {
                super.getCompareResult();
            }
            else if (this.result == FightResult.WAR_1_4.ordinal()) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
            }
            else if (this.result == FightResult.WAR_2_4.ordinal()) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
            }
            else if (this.result == FightResult.WAR_3_4.ordinal()) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
            }
            else {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1), this.cartsToCompare.get(2));
            }
        }

        if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_4.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_4.ordinal()) {
            this.result = FightResult.FOURTH_WIN.ordinal();
        }
        if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_2_4.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_2_4.ordinal()) {
            this.result = FightResult.FOURTH_WIN.ordinal();
        }
        if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_3_4.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_3_4.ordinal()) {
            this.result =  FightResult.FOURTH_WIN.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.THIRD_WIN.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_2.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.WAR_1_2.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_3.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.WAR_1_3.ordinal();
        }
        else if (bufforResult == FightResult.WAR_2_3.ordinal() && this.result == FightResult.WAR_1_2_3.ordinal()) {
            this.result = FightResult.WAR_2_3.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.THIRD_WIN.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.FOURTH_WIN.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_2.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.WAR_1_2.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_3.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.WAR_1_4.ordinal();
        }
        else if (bufforResult == FightResult.WAR_2_3.ordinal() && this.result == FightResult.WAR_1_2_4.ordinal()) {
            this.result = FightResult.WAR_2_4.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result = FightResult.FIRST_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
        else if (bufforResult == FightResult.THIRD_WIN.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result =  FightResult.FOURTH_WIN.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_2.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result = FightResult.WAR_1_3.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_3.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result = FightResult.WAR_1_4.ordinal();
        }
        else if (bufforResult == FightResult.WAR_2_3.ordinal() && this.result == FightResult.WAR_1_3_4.ordinal()) {
            this.result = FightResult.WAR_3_4.ordinal();
        }
        else if (bufforResult == FightResult.FIRST_WIN.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.SECOND_WIN.ordinal();
        }
        else if (bufforResult == FightResult.SECOND_WIN.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.THIRD_WIN.ordinal();
        }
        else if (bufforResult == FightResult.THIRD_WIN.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.FOURTH_WIN.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_2.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.WAR_2_3.ordinal();
        }
        else if (bufforResult == FightResult.WAR_1_3.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.WAR_2_4.ordinal();
        }
        else if (bufforResult == FightResult.WAR_2_3.ordinal() && this.result == FightResult.WAR_2_3_4.ordinal()) {
            this.result = FightResult.WAR_3_4.ordinal();
        }
    }

    @Override
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
        else if (result == FightResult.FOURTH_WIN.ordinal()) {
            getChooseAfterWin();
        }
        else if (result == FightResult.WAR_1_2.ordinal()){
            super.showResultWithCompare(result);
        }
        else if (result == FightResult.WAR_1_3.ordinal()) {
            super.showResultWithCompare(result);
        }
        else if (result == FightResult.WAR_2_3.ordinal()) {
            super.showResultWithCompare(result);
        }
        else if (result == FightResult.WAR_1_2_3_4.ordinal()) {
            super.showResultWithCompare(result);
        }
        else if (result == FightResult.WAR_1_4.ordinal()) {
            view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(3).getName()));
        }
        else if (result == FightResult.WAR_2_4.ordinal()) {
            view.println(String.format("Draw! %s and %s", players.get(1).getName(), players.get(3).getName()));
        }
        else if (result == FightResult.WAR_3_4.ordinal()) {
            view.println(String.format("Draw! %s and %s", players.get(2).getName(), players.get(3).getName()));
        }
        else if (result == FightResult.WAR_1_2_3.ordinal()) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(1).getName(), players.get(2).getName()));
        }
        else if (result == FightResult.WAR_1_2_4.ordinal()) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(1).getName(), players.get(3).getName()));
        }
        else if (result == FightResult.WAR_1_3_4.ordinal()) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(2).getName(), players.get(3).getName()));
        }
        else  {
            view.println(String.format("Draw! %s, %s and %s", players.get(1).getName(), players.get(2).getName(), players.get(3).getName()));
        }
    }
}
