package com.codecool.app;

public class Card {
    private String name;
    private int first, second, third, fourth, fifth, sixth;
    /* for football players:
    private int pace, shooting, passing, dribbling, defending, physic; */
    private boolean isHidden;

    public Card(String name, int first, int second, int third, int fourth, int fifth, int sixth) {
        this.name = name;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        isHidden = true;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setCardVisible() {
        this.isHidden = false;
    }

    public void setCardHidden() {
        this.isHidden = true;
    }

    public String getName() {
        return name;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public int getSixth() {
        return sixth;
    }

    public int getBiggestField(){return first; }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder();

        card.append("name: " + name + "/ pace: " + first + "/ shooting: " + second + "/ passing: " + third + "/ dribbling: " + fourth + "/ defence: " + fifth + 
        "/ physic: " + sixth);

        return card.toString();
    }
}