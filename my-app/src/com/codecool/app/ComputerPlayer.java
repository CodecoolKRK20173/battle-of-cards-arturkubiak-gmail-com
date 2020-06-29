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

        System.out.println(card.toString());
        System.out.println("Computer choose field: " + card.getBiggestField());
        return card.getBiggestField();
    }
}
