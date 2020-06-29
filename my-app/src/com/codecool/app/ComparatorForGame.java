package com.codecool.app;

import java.util.Comparator;

public class ComparatorForGame implements Comparator<Card> {

    enum FightResult {
        FIRST_WIN, SECOND_WIN, THIRD_WIN, FOURTH_WIN, WAR_1_2, WAR_1_3, WAR_1_4, WAR_2_3,
        WAR_2_4, WAR_3_4, WAR_1_2_3, WAR_1_2_4, WAR_1_3_4, WAR_2_3_4, WAR_1_2_3_4;
    }

    @Override
    public int compare(Card card1, Card card2) {

        if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose())) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2.ordinal();
        }
        else {
            return FightResult.SECOND_WIN.ordinal();
        }
    }

    public int compare(Card card1, Card card2, Card card3){

        if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card1.getChoose()) > card3.getAtribute(card2.getChoose()))) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (card1.getAtribute(card2.getChoose()) > card1.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card2.getChoose()) > card3.getAtribute(card2.getChoose()))) {
            return FightResult.SECOND_WIN.ordinal();
        }
        else if (card1.getAtribute(card3.getChoose()) > card1.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card3.getChoose()) > card2.getAtribute(card2.getChoose()))) {
            return FightResult.THIRD_WIN.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card2.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2_3.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_3.ordinal();
        }
        else if (card1.getAtribute(card2.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_2_3.ordinal();
        }
        else {
            //not used
            return FightResult.SECOND_WIN.ordinal();
        }
    }

    public int compare(Card card1, Card card2, Card card3, Card card4) {

        if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card1.getChoose()) > card3.getAtribute(card2.getChoose())) &&
                (card1.getAtribute(card1.getChoose()) > card3.getAtribute(card4.getChoose()))) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (card1.getAtribute(card2.getChoose()) > card1.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card2.getChoose()) > card3.getAtribute(card2.getChoose())) &&
                (card1.getAtribute(card2.getChoose()) > card4.getAtribute(card2.getChoose()))) {
            return FightResult.SECOND_WIN.ordinal();
        }
        else if (card1.getAtribute(card3.getChoose()) > card1.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card3.getChoose()) > card4.getAtribute(card2.getChoose())) &&
                (card1.getAtribute(card3.getChoose()) > card2.getAtribute(card2.getChoose()))) {
            return FightResult.THIRD_WIN.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card2.getChoose()) == card3.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card3.getChoose()) == card4.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2_3_4.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card2.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card3.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_3.ordinal();
        }
        else if (card1.getAtribute(card2.getChoose()) == card3.getAtribute(card2.getChoose())) {
            return FightResult.WAR_2_3.ordinal();
        }
        else {
            //not used
            return FightResult.SECOND_WIN.ordinal();
        }
    }
}
