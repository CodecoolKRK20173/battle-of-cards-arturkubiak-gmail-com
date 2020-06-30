package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForFour extends QuarterGameForThree {

    public QuarterGameForFour(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        super(deckToGame, isUser);
    }

    @Override
    protected void quarter(View view, QuarterGame game) {

        while (game.areEnoughPlayers()) {
            if (this.result == 0 || this.result == 1 || this.result == 2 || this.result == 3 || this.result == 14) {
                for (Player player : this.players) {
                    player.getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(player.next());
                }
            }
            else if (this.result == 4 || this.result == 5 || this.result == 7) {
                super.addCardsToCompareIfDraw(this.result);
            }
            else {
                addCardsToCompareIfDraw(this.result);
            }
            getCompareResult();
            addCartsToPlayers(view, game);
        }
        removePlayer();
        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter(view, game);
    }

    @Override
    protected void addCardsToCompareIfDraw(int result) {
        if (result == 6) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(3).next());
        }
        else if (result == 8) {
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(1).next());
            this.cartsToCompare.add(this.players.get(3).next());
        }
        else if (result == 9) {
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(2).next());
            this.cartsToCompare.add(this.players.get(3).next());
        }
        else if (result == 10) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(1).next());
            this.cartsToCompare.add(this.players.get(2).next());
        }
        else if (result == 11) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(1).next());
            this.cartsToCompare.add(this.players.get(3).next());
        }
        else if (result == 12) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(2).next());
            this.cartsToCompare.add(this.players.get(3).next());
        }
        else {
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(3).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(1).next());
            this.cartsToCompare.add(this.players.get(2).next());
            this.cartsToCompare.add(this.players.get(3).next());
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
            if (this.result == 4 || this.result == 5 || this.result == 7 || this.result == 10) {
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
    protected void showResultWithCompare(View view, QuarterGame game, int result) {
        if (result == 0 || result == 1 || result == 2 || result == 3) {
            this.cardsInBuffer.clear();
            game.getChooseAfterWin(view, game);
        }
        else if (result == 4 || result == 5 || result == 7 || result == 14){
            super.showResultWithCompare(view, game, result);
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
