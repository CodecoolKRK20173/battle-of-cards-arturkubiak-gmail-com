package com.codecool.app;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, ArrayList<Card> cards) {
        super(name, cards);
        Name = name;
        Cards = cards;
    }


    @Override
    public int chooseCardField() {
        Card card = Cards.get(0);

        GameBoard gameBoard = new GameBoard();
        PrintBoard newPrint = new PrintBoard(gameBoard.createChoiceBoard(Name, Cards, card));
        newPrint.displayBoard();

        int biggestField = card.getBiggestField();

        // System.out.println(card.toString());
        System.out.println("Number of picked statistic: " + (biggestField + 1));
        return biggestField;
    }
}
