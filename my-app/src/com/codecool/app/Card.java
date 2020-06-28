package com.codecool.app;

import java.util.ArrayList;
import java.util.Collections;

public class Card {
    private String name;
    private int first, second, third, fourth, fifth, sixth, choose;
    /* for football players:
    private int pace, shooting, passing, dribbling, defending, physic; */
    private boolean isHidden;
    private ArrayList<Integer> attributeList= new ArrayList<Integer>();


    public Card(String name, int first, int second, int third, int fourth, int fifth, int sixth) {
        this.name = name;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        isHidden = true;
        createAttributeList();
        this.choose = 0;
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

    private void createAttributeList(){
        attributeList.add(first); attributeList.add(second); attributeList.add(third);
        attributeList.add(fourth); attributeList.add(fifth); attributeList.add(sixth);
    }

    private ArrayList<Double> getMultiplyAtrList(){
        ArrayList<Double> biggestAttributeList= new ArrayList<Double>();
        ArrayList<Double> rateList= new ArrayList<Double>();
        double firstRate = 1.12; rateList.add(firstRate);
        double secondRate = 1.17; rateList.add(secondRate);
        double thirdRate = 1.1; rateList.add(thirdRate);
        double fourthRate = 1; rateList.add(fourthRate);
        double fifthRate = 1.3; rateList.add(fifthRate);
        double sixthRate = 1.12; rateList.add(sixthRate);

        for(int ele = 0; ele <6; ele++){
            biggestAttributeList.add(rateList.get(ele)* attributeList.get(ele));
        }
        return biggestAttributeList;
    }

    public int getAtribute(int choosenAtribute){
        return attributeList.get(choosenAtribute);
    }

    public int getBiggestField() {
        ArrayList<Double> listOfArgs = getMultiplyAtrList();
        int counter = 0;
        double maxVale = 0;

        for (int i = 0; i < listOfArgs.size(); i++) {
            if (listOfArgs.get(i) > maxVale) {
                maxVale = listOfArgs.get(i);
                counter = i;
            }
        }
        return counter;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder();

        card.append("name: " + name + "/ pace: " + first + "/ shooting: " + second + "/ passing: " + third + "/ dribbling: " + fourth + "/ defence: " + fifth + 
        "/ physic: " + sixth);

        return card.toString();
    }
}