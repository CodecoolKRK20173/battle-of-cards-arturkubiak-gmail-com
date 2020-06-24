package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private int deckSize;

    public Deck(int deckSize) {
        this.deckSize = deckSize;
    }

    public List<List<String>> selectCardsFromData(List<List<String>> cardsData) {
        List<List<String>> selectedCards = new ArrayList<>();
        int dataSize = cardsData.size();
        Random newRandom = new Random();
                
        for(int i = 0; i < deckSize; i++) {
            int newCardIndex = newRandom.nextInt(dataSize);
            selectedCards.add(cardsData.get(newCardIndex));
        }

        return selectedCards;
    }

    public void addCardsToDeck(List<List<String>> selectedCards) {
        for(List<String> data : selectedCards) {
            int first = Integer. parseInt(data.get(1));
            int second = Integer. parseInt(data.get(2));
            int third = Integer. parseInt(data.get(3));
            int fourth = Integer. parseInt(data.get(4));
            int fifth = Integer. parseInt(data.get(5));
            int sixth = Integer. parseInt(data.get(6));
            
            Card singleCard = new Card(data.get(0), first, second, third, fourth, fifth, sixth);
            deck.add(singleCard);
        }
    }

    public List<Card> getDeck() {
        return deck;
    }
    
}