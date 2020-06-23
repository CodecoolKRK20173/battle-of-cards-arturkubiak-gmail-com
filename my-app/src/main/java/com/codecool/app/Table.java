package com.codecool.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Table {
    //private List<Card> deckOfCards;
/*
    public Table(Card deckOfCards) {
        this.deckOfCards = (List<Card>) deckOfCards;
    }
*/
    void run() {
        boolean isRun = true;

        Table table = new Table();
        View view = new View();

        while (isRun) {
            view.clearScreen();
            view.printMenu();

            int option = table.returnOption(view);

            switch (option) {
                case 1:
                    ///
                    break;
                case 2:
                    view.println("Good bye!");
                    isRun = false;
                    break;
            }
        }
    }

    private Integer returnOption(View view) {
        int option = 0;
        Scanner scan = new Scanner(System.in);

        view.print("Privide number of option: ");

        try {
            option = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.next();
        }
        return option;
    }
}
