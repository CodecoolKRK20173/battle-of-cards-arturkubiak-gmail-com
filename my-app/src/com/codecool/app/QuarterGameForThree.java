package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForThree extends QuarterGame {

    public QuarterGameForThree(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        super(deckToGame, isUser);
    }

    @Override
    protected void quarter(View view, QuarterGame game) {

        if (this.players.size() == 3) {

            while (game.areEnoughPlayers()) {

                if (this.result == 0 || this.result == 1 || this.result == 2 || this.result == 10) {
                    for (Player player : this.players) {
                        player.getCards().get(0).setChoose(this.chooseToComare);
                        this.cartsToCompare.add(player.next());
                    }
                }
                else {
                    addCardsToCompareIfDraw(this.result);
                }
                getCompareResult();
                addCartsToPlayers(view, game);
            }
        }
        afterBreakLoop(view, game);
    }

    protected void addCardsToCompareIfDraw(int result) {
        if (result == 4) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(1).next());
        } else if (result == 5) {
            this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(0).next());
            this.cartsToCompare.add(this.players.get(2).next());
        } else {
            this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
            this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
            this.cartsToCompare.add(this.players.get(1).next());
            this.cartsToCompare.add(this.players.get(2).next());
        }
    }

    protected void addCartsToPlayers(View view, QuarterGame game) {
        this.cardsInBuffer.addAll(this.cartsToCompare);
        this.cartsToCompare.clear();

        if (result == 0 || result == 1 || result == 2 || result == 3) {
            this.players.get(result).getCards().addAll(this.cardsInBuffer);
        }
        showResultWithCompare(view, game, this.result);
    }

    protected void showResultWithCompare(View view, QuarterGame game, int result) {
        if (result == 0 || result == 1 || result == 2) {
            this.cardsInBuffer.clear();
            game.getChooseAfterWin(view, game);
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
            game.quantityCardsOfPlayers(view);
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

    protected void afterBreakLoop(View view, QuarterGame game) {
        removePlayer();
        super.cardsInBuffer.addAll(this.cardsInBuffer);
        super.quarter(view, game);
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
