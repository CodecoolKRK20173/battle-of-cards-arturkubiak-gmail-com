package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name, ArrayList<Card> cards) {
        super(name, cards);
        Name = name;
        Cards = cards;
    }


    @Override
    public int chooseCardField() {
        Card card = next();
        return card.getBiggestField();
    }
}
