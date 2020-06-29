package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class QuarterGameForThree extends QuarterGame {

    public QuarterGameForThree(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        super(deckToGame, isUser);
    }

    @Override
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


            if ((result == 0 || result == 1 || result == 2) && deckToGame.size() == 3) {
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
                if (!players.get(index).hasNext()) {
                    players.remove(index);
                }
            }
        }
    }

    @Override
    protected void quantityCardsOfPlayers(View view) {
        super.quantityCardsOfPlayers(view);
        view.println(String.format("%s has %d Card's", this.players.get(2).getName(), this.players.get(2).getCards().size()));
    }
}
