package com.codecool.app;

import java.util.ArrayList;

public class CardContainer {
    private ArrayList<Card> CardList;

    public CardContainer(ArrayList<Card> cardList) {
        CardList = cardList;
    }

    public CardContainer() {
        this.CardList = new ArrayList<Card>();
    }

    public void  addCard(Card card){
        CardList.add(card);
    }

    public void removeCard(int index){
//        to handle sameexeption
        CardList.remove(index);
    }

    public void getCard(int index){

        //         to handle sameexeption


    }
}
