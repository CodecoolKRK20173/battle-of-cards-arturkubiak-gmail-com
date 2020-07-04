package com.codecool.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<String> stats = Arrays.asList("PACE", "SHOOTING", "PASSING", "DRIBBLING", "DEFENCE", "PHYSIC");
        System.out.println(Name.toUpperCase() + " picked " + stats.get(biggestField + 1) + " fot next round");

        return biggestField;
    }
}
