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

            if (this.result == 0 || this.result == 1 || this.result == 2 || this.result == 3 || this.result == 14) {
                addCartFromAllPlayers();
            } else if (this.result == 4 || this.result == 5 || this.result == 7) {
                super.addCardsToCompareIfDraw(this.result);
            } else {
                addCardsToCompareIfDraw(this.result);
            }
            getCompareResult();
            addCartsToPlayers();
            removePlayer();
        }

        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter();
    }

    @Override
    protected void addCardsToCompareIfDraw(int result) {
        int []tab;

        if (result == 6) {
            tab = new int[]{0, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else if (result == 8) {
            tab = new int[]{1, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else if (result == 9) {
            tab = new int[]{2, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else if (result == 10) {
            tab = new int[]{0, 1, 2};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else if (result == 11) {
            tab = new int[]{0, 1, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else if (result == 12) {
            tab = new int[]{0, 2, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
        }
        else {
            tab = new int[]{1, 2, 3};
            for (int value : tab) {
                this.players.get(value).getCards().get(0).setChoose(this.chooseToComare);
                this.playersInGame.add(players.get(value));
                this.cartsToCompare.add(this.players.get(value).next());
            }
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
            if (this.result == 4 || this.result == 5 || this.result == 7) {
                super.getCompareResult();
            }
            else if (this.result == 6 || this.result == 8 || this.result == 9) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
            }
            else {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1), this.cartsToCompare.get(2));
            }
        }

        if (bufforResult == 0 && this.result == 6) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 6) {
            this.result = 3;
        }
        if (bufforResult == 0 && this.result == 8) {
            this.result = 1;
        }
        else if (bufforResult == 1 && this.result == 8) {
            this.result = 3;
        }
        if (bufforResult == 0 && this.result == 9) {
            this.result = 2;
        }
        else if (bufforResult == 1 && this.result == 9) {
            this.result = 3;
        }
        else if (bufforResult == 0 && this.result == 10) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 10) {
            this.result = 1;
        }
        else if (bufforResult == 2 && this.result == 10) {
            this.result = 2;
        }
        else if (bufforResult == 4 && this.result == 10) {
            this.result = 4;
        }
        else if (bufforResult == 5 && this.result == 10) {
            this.result = 5;
        }
        else if (bufforResult == 7 && this.result == 10) {
            this.result = 7;
        }
        else if (bufforResult == 0 && this.result == 11) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 11) {
            this.result = 1;
        }
        else if (bufforResult == 2 && this.result == 11) {
            this.result = 3;
        }
        else if (bufforResult == 4 && this.result == 11) {
            this.result = 4;
        }
        else if (bufforResult == 5 && this.result == 11) {
            this.result = 6;
        }
        else if (bufforResult == 7 && this.result == 11) {
            this.result = 8;
        }
        else if (bufforResult == 0 && this.result == 12) {
            this.result = 0;
        }
        else if (bufforResult == 1 && this.result == 12) {
            this.result = 2;
        }
        else if (bufforResult == 2 && this.result == 12) {
            this.result = 3;
        }
        else if (bufforResult == 4 && this.result == 12) {
            this.result = 5;
        }
        else if (bufforResult == 5 && this.result == 12) {
            this.result = 6;
        }
        else if (bufforResult == 7 && this.result == 12) {
            this.result = 9;
        }
        else if (bufforResult == 0 && this.result == 13) {
            this.result = 1;
        }
        else if (bufforResult == 1 && this.result == 13) {
            this.result = 2;
        }
        else if (bufforResult == 2 && this.result == 13) {
            this.result = 3;
        }
        else if (bufforResult == 4 && this.result == 13) {
            this.result = 7;
        }
        else if (bufforResult == 5 && this.result == 13) {
            this.result = 8;
        }
        else if (bufforResult == 7 && this.result == 13) {
            this.result = 9;
        }
    }

    @Override
    protected void showResultWithCompare(int result) {
        if (result == 0 || result == 1 || result == 2 || result == 3) {
            this.cardsInBuffer.clear();
            getChooseAfterWin();
        }
        else if (result == 4 || result == 5 || result == 7 || result == 14){
            super.showResultWithCompare(result);
        }
        else if (result == 6) {
            view.println(String.format("Draw! %s and %s", players.get(0).getName(), players.get(3).getName()));
        }
        else if (result == 8) {
            view.println(String.format("Draw! %s and %s", players.get(1).getName(), players.get(3).getName()));
        }
        else if (result == 9) {
            view.println(String.format("Draw! %s and %s", players.get(2).getName(), players.get(3).getName()));
        }
        else if (result == 10) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(1).getName(), players.get(2).getName()));
        }
        else if (result == 11) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(1).getName(), players.get(3).getName()));
        }
        else if (result == 12) {
            view.println(String.format("Draw! %s, %s and %s", players.get(0).getName(), players.get(2).getName(), players.get(3).getName()));
        }
        else  {
            view.println(String.format("Draw! %s, %s and %s", players.get(1).getName(), players.get(2).getName(), players.get(3).getName()));
        }
    }
}
