package com.codecool.app;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Player implements Iterator<Card>  {

    public String Name;
    public ArrayList<Card> Cards;

    public Player(String name, ArrayList<Card> cards) {
        Name = name;
        Cards = cards;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Card> getCards() {
        return Cards;
    }

    public  abstract int chooseCardField();

    @Override
    public boolean hasNext(){
        return Cards.size() > 0 ? true : false;
    }

    @Override
    public  Card next(){
        Card card = Cards.get(0);
        remove();
        return  card;
    }

    @Override
    public void remove(){
        Cards.remove(0);
    }

}



