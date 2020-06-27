package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuarterGame {
    private ArrayList<Card> deckToGame;
    private List<Boolean> isUser;
    private ArrayList<Player> players = new ArrayList<>();

    public QuarterGame(ArrayList<Card> deckToGame, List<Boolean> isUser) {
        this.deckToGame = deckToGame;
        this.isUser = isUser;
    }

    void run(QuarterGame game, View view, Scanner scan) {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        ArrayList<Card> deckFirstPlayer = new ArrayList<>();
        ArrayList<Card> deckSecondPlayer = new ArrayList<>();
        int sizeOfDeck = deckToGame.size();

        for (int index = 0; index < sizeOfDeck; index++) {
            Card card = this.deckToGame.get(0);
            this.deckToGame.remove(this.deckToGame.get(0));

            if (index % 2 == 0) {
                deckFirstPlayer.add(card);
            }
            else {
                deckSecondPlayer.add(card);
            }
            decks.add(deckFirstPlayer);
            decks.add(deckSecondPlayer);
        }
        game.getPlayersObject(decks, view, scan);
        game.quarter(view);

        this.players.clear();
        this.isUser.clear();
        this.deckToGame.clear();
    }

    private void getPlayersObject(ArrayList<ArrayList<Card>> decks, View view, Scanner scan) {
        for (int index = 0; index < isUser.size(); index++) {
            if (isUser.get(index)) {
                view.print("Provide your name: ");
                String name = scan.nextLine();
                this.players.add(new UserPlayer(name, decks.get(index)));
            }
            else {
                String name = String.format("enemy%d", index + 1);
                this.players.add(new ComputerPlayer(name, decks.get(index)));
            }
        }
    }

    private void quarter(View view) {
        ArrayList<Card> cardsInBuffer =  new ArrayList<>();
        ArrayList<Card> cartsToCompare =  new ArrayList<>();
        ComparatorForGame comparator = new ComparatorForGame();
        //+++++++++++
        int queue = 0; //to remove
        //+++++++++++

        while (this.players.get(0).hasNext() && this.players.get(1).hasNext()) {
            //++++++++++
            queue++; //to remove
            //++++++++++
            System.out.println(queue);

            int result = 0;
            for (Player player : this.players) {
                if (player.hasNext()) {
                    cartsToCompare.add(player.next());
                }
            }

            result = comparator.compare(cartsToCompare.get(0), cartsToCompare.get(1));
            cardsInBuffer.addAll(cartsToCompare);
            cartsToCompare.clear();

            if (result == 0 || result == 1) {
                this.players.get(result).getCards().addAll(cardsInBuffer);
                cardsInBuffer.clear();
            }
        }

        if (this.players.get(0).hasNext()) {
            view.println("Player 1 win!!!");
        }
        else {
            view.println("Player 2 win!!!");
        }

//        Player bj = new UserPlayer("BJ", (ArrayList<Card>) deckFirstPlayer);
//        bj.chooseCardField();

//        System.out.println(deckFirstPlayer.toString());
//        System.out.println(deckFirstPlayer.size());
//        System.out.println(deckSecondPlayer.toString());
//        System.out.println(deckSecondPlayer.size());

    }
}
