package com.codecool.app;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPlayer extends Player {

    public UserPlayer(String name, ArrayList<Card> cards) {
        super(name, cards);
        Name = name;
        Cards = cards;
    }


    private int getField() {
        boolean isRun = true;
        int choosenfiel = 0;

        while (isRun) {
            //view.print("Provide` you option: ");
            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine().toUpperCase().trim();
            int choosenCorrect = 1;

            if (option.equals("ONE") || option.equals("PACE") || option.equals("P") || option.equals("1")) {
                choosenfiel = 1 - choosenCorrect;
                return choosenfiel;
            }
            else if (option.equals("TWO") || option.equals("SHOOTING") || option.equals("SHO")  || option.equals("2")) {
                choosenfiel = 2 - choosenCorrect;
                return choosenfiel;
            }
            else if (option.equals("THREE") || option.equals("PASSING") || option.equals("PAS")  || option.equals("3")) {
                choosenfiel = 3 - choosenCorrect;
                return choosenfiel;
            }
            else if (option.equals("FOUR") || option.equals("DRIBBLING") || option.equals("DRI")  || option.equals("4")) {
                choosenfiel = 4 - choosenCorrect;
                return choosenfiel;
            }
            else if (option.equals("FIVE") || option.equals("DEFENCE") || option.equals("DEF")  || option.equals("5")) {
                choosenfiel = 5 - choosenCorrect;
                return choosenfiel;
            }
            else if (option.equals("SIX") || option.equals("PHYSIC") || option.equals("PHY")  || option.equals("6")) {
                choosenfiel = 6 - choosenCorrect;
                return choosenfiel;
            }
            else {
                System.out.println("Wrong option! Try again");
            }
        }
        return choosenfiel;
    }

    @Override
    public int chooseCardField() {
        Card card = Cards.get(0);
        System.out.println("User choose:");
        System.out.println(card.toString());
        int choosenField = getField();
        System.out.println("User choose field: " + choosenField);
        return  choosenField;
    }
}
