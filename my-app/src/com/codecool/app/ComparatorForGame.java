package com.codecool.app;

public class ComparatorForGame implements ComparatorQuarter {

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

    @Override
    public int compare(Card card1, Card card2, Card card3){

        if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card1.getChoose()) > card3.getAtribute(card3.getChoose()))) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (card2.getAtribute(card2.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                (card2.getAtribute(card2.getChoose()) > card3.getAtribute(card3.getChoose()))) {
            return FightResult.SECOND_WIN.ordinal();
        }
        else if (card3.getAtribute(card3.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                (card3.getAtribute(card3.getChoose()) > card2.getAtribute(card2.getChoose()))) {
            return FightResult.THIRD_WIN.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose())) {
            return FightResult.WAR_1_2_3.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose())) {
            return FightResult.WAR_1_2.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose())) {
            return FightResult.WAR_1_3.ordinal();
        }
        else  {
            return FightResult.WAR_2_3.ordinal();
        }
    }

    @Override
    public int compare(Card card1, Card card2, Card card3, Card card4) {

        if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                (card1.getAtribute(card1.getChoose()) > card3.getAtribute(card3.getChoose())) &&
                (card1.getAtribute(card1.getChoose()) > card4.getAtribute(card4.getChoose()))) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (card2.getAtribute(card2.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                (card2.getAtribute(card2.getChoose()) > card3.getAtribute(card3.getChoose())) &&
                (card2.getAtribute(card2.getChoose()) > card4.getAtribute(card4.getChoose()))) {
            return FightResult.SECOND_WIN.ordinal();
        }
        else if (card3.getAtribute(card3.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                (card3.getAtribute(card3.getChoose()) > card2.getAtribute(card2.getChoose())) &&
                (card3.getAtribute(card3.getChoose()) > card4.getAtribute(card4.getChoose()))) {
            return FightResult.THIRD_WIN.ordinal();
        }
        else if (card4.getAtribute(card4.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                (card4.getAtribute(card4.getChoose()) > card2.getAtribute(card2.getChoose())) &&
                (card4.getAtribute(card4.getChoose()) > card3.getAtribute(card3.getChoose()))) {
            return FightResult.FOURTH_WIN.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_2_3_4.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_2.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_3.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card4.getAtribute(card4.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card3.getAtribute(card3.getChoose())) {
            return FightResult.WAR_1_4.ordinal();
        }
        else if (card2.getAtribute(card2.getChoose()) == card3.getAtribute(card3.getChoose()) &&
                card2.getAtribute(card2.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                card2.getAtribute(card2.getChoose()) > card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_2_3.ordinal();
        }
        else if (card2.getAtribute(card2.getChoose()) == card4.getAtribute(card4.getChoose()) &&
                card2.getAtribute(card2.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                card2.getAtribute(card2.getChoose()) > card3.getAtribute(card3.getChoose())) {
            return FightResult.WAR_2_4.ordinal();
        }
        else if (card3.getAtribute(card3.getChoose()) == card4.getAtribute(card4.getChoose()) &&
                card3.getAtribute(card3.getChoose()) > card1.getAtribute(card1.getChoose()) &&
                card3.getAtribute(card3.getChoose()) > card2.getAtribute(card2.getChoose())) {
            return FightResult.WAR_3_4.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_2_3.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) > card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_3_4.ordinal();
        }
        else if (card1.getAtribute(card1.getChoose()) == card2.getAtribute(card2.getChoose()) &&
                card1.getAtribute(card1.getChoose()) > card3.getAtribute(card3.getChoose()) &&
                card1.getAtribute(card1.getChoose()) == card4.getAtribute(card4.getChoose())) {
            return FightResult.WAR_1_2_4.ordinal();
        }
        else {
            return FightResult.WAR_2_3_4.ordinal();
        }
    }
}
