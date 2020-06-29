package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForThree extends QuarterGame {

    public QuarterGameForThree(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        super(deckToGame, isUser);
    }

    @Override
    protected void quarter(View view, QuarterGame game) {

        while (this.players.get(0).hasNext() && this.players.get(1).hasNext() && this.players.get(2).hasNext()) {

            if (this.result == 0 || this.result == 1 || this.result == 2 || this.result == 10) {
                for (Player player : this.players) {
                    player.getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(player.next());
                }
            }
            else {
                if (result == 4) {
                    this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
                    this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(this.players.get(0).next());
                    this.cartsToCompare.add(this.players.get(1).next());
                }
                else if (result == 5) {
                    this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
                    this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(this.players.get(0).next());
                    this.cartsToCompare.add(this.players.get(2).next());
                }
                else {
                    this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
                    this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
                    this.cartsToCompare.add(this.players.get(1).next());
                    this.cartsToCompare.add(this.players.get(2).next());
                }
            }
            getCompareResult();
            addCartsToPlayers(view, game);
        }
        removePlayer();
        super.quarter(view, game);
    }

    protected void addCartsToPlayers(View view, QuarterGame game) {
        this.cardsInBuffer.addAll(this.cartsToCompare);
        this.cartsToCompare.clear();

        if (result == 0) {
            this.players.get(0).getCards().addAll(this.cardsInBuffer);
        }
        else if (result == 1) {
            this.players.get(1).getCards().addAll(this.cardsInBuffer);
        }
        else if (result == 2) {
            this.players.get(2).getCards().addAll(this.cardsInBuffer);
        }

        if (result == 0 || result == 1 || result == 2) {
            this.cardsInBuffer.clear();
            game.getChooseAfterWin(view, game);
        }
        else {
            view.println("Draw");
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
            if (this.result == 4) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(1));
            }
            else if (this.result == 5) {
                bufforResult = comparator.compare(this.cartsToCompare.get(0), this.cartsToCompare.get(2));
            }
            else {
                bufforResult = comparator.compare(this.cartsToCompare.get(1), this.cartsToCompare.get(2));
            }
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

    /*
    protected void quarter(View view, QuarterGame game) {
        ArrayList<Card> cardsInBuffer =  new ArrayList<>();
        ArrayList<Card> cartsToCompare =  new ArrayList<>();
        ComparatorForGame comparator = new ComparatorForGame();
        view.println(String.format("%s are choosing", players.get(0).getName()));
        this.chooseToComare = players.get(0).chooseCardField();
        int result = 0;
        int bufforRes = 0;

        while (this.players.size() > 1) {
            if (result == 5 && this.players.size() == 3) {
                this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(0).next());
                this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(1).next());
             }
            else if (result == 6 && this.players.size() == 3) {
                this.players.get(0).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(0).next());
                this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(2).next());
            }
            else if (result == 7 && this.players.size() == 3) {
                this.players.get(1).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(1).next());
                this.players.get(2).getCards().get(0).setChoose(this.chooseToComare);
                cartsToCompare.add(this.players.get(2).next());
            }
            else {
                for (Player player : this.players) {
                    player.getCards().get(0).setChoose(this.chooseToComare);
                    cartsToCompare.add(player.next());
                }
            }


            if ((result == 0 || result == 1 || result == 2) && players.size() == 3) {
                result = comparator.compare(cartsToCompare.get(0), cartsToCompare.get(1), cartsToCompare.get(2));
            }
            else {
                bufforRes = result;
                result = comparator.compare(cartsToCompare.get(0), cartsToCompare.get(1));

                if ((bufforRes == 4 || bufforRes == 5 || bufforRes == 7) && result == 4) {
                    result = bufforRes;
                }
                else if (result == 0 && bufforRes == 4) {
                    result = 0;
                }
                else if (result == 1 && bufforRes == 4) {
                    result = 1;
                }
                else if (result == 0 && bufforRes == 5) {
                    result = 0;
                }
                else if (result == 1 && bufforRes == 5) {
                    result = 2;
                }
                else if (result == 1 && bufforRes == 7) {
                    result = 1;
                }
                else {
                    result = 2;
                }
            }


            cardsInBuffer.addAll(cartsToCompare);
            cartsToCompare.clear();

            if (result == 0 || result == 1 || result == 2) {
                this.players.get(result).getCards().addAll(cardsInBuffer);
                cardsInBuffer.clear();

                if (result == 0) {
                    view.println(String.format("%s win battle", players.get(0).getName()));
                    game.quantityCardsOfPlayers(view);
                    view.println(String.format("%s are choosing", players.get(0).getName()));
                    this.chooseToComare = players.get(0).chooseCardField();
                }
                else if (result == 1) {
                    view.println(String.format("%s win battle", players.get(1).getName()));
                    game.quantityCardsOfPlayers(view);
                    view.println(String.format("%s are choosing", players.get(1).getName()));
                    this.chooseToComare = players.get(1).chooseCardField();
                }
                else {
                    view.println(String.format("%s win battle", players.get(2).getName()));
                    game.quantityCardsOfPlayers(view);
                    view.println(String.format("%s are choosing", players.get(2).getName()));
                    this.chooseToComare = players.get(2).chooseCardField();
                }
            }
            else {
                if (result == 4) {
                    view.println("Draw! Player1 and Player2.");
                }
                else if (result == 5) {
                    view.println("Draw! Player1 and Player3.");
                }
                else if (result == 7) {
                    view.println("Draw! Player2 and Player3.");
                }
                else {
                    view.println("Draw! All of players.");
                }
                game.quantityCardsOfPlayers(view);
            }



            for (int index = this.players.size(); index > 0; index--) {
                if (!this.players.get(index).hasNext()) {
                    this.players.remove(this.players.get(index));
                }
            }
        }
    }*/

}
