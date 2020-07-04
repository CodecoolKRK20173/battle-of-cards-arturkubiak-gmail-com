package com.codecool.app;

import java.util.*;

public class Table {
    private int countOfCard;
    private int countOfPlayers;
    private List<Boolean> isUser = new ArrayList<>();
    private View view = new View();
    private Scanner scan = new Scanner(System.in);

    public Table() {
        this.countOfCard = 0;
    }

    void run() {
        boolean isRun = true;

        while (isRun) {
            view.clearScreen();
            view.printMenu();

            int option = returnOption();

            switch (option) {
                case 1:
                    chooseOptionOfGame();
                    launchGame();
                    break;
                case 2:
                    view.clearScreen();
                    view.printRules("./src/resources/Rules.txt");
                    view.pressEnter();
                    break;
                case 3:
                    view.println("Good bye!");
                    isRun = false;
                    break;
            }
        }
        scan.close();
    }

    private Integer returnOption() {
        int option = 0;

        try {
            option = view.getOption();
        } catch (InputMismatchException e) {
            scan.next();
        }
        return option;
    }

    private void chooseOptionOfGame() {
        chooseCountOfCard();
        view.println("");
        chooseCountPlayers();
        chooseUserEnemy();
    }

    private void chooseCountOfCard() {
        boolean isRun = true;
        String option = "";

        while (isRun) {
            view.println("How many cards do you want to play with?");
            option = view.chooseCountOfCard();

            if (option.equals("24") || option.equals("TWENTY") || option.equals("T") || option.equals("1")) {
                setCountOfCard(24);
                isRun = false;
            }
            else if (option.equals("60") || option.equals("SIXTY") || option.equals("T")  || option.equals("2")) {
                setCountOfCard(60);
                isRun = false;
            }
            view.clearScreen();
        }
    }

    private void chooseCountPlayers() {
        boolean isRun = true;

        while (isRun) {
            view.println("How many players do you want to set up?");
            String option = view.chooseCountPlayers();

            if (option.equals("TWO") || option.equals("2")) {
                setCountOfPlayers(2);
                isRun = false;
            }
            else if (option.equals("THREE") || option.equals("3")) {
                setCountOfPlayers(3);
                isRun = false;
            }
            else if (option.equals("FOUR") || option.equals("4")) {
                setCountOfPlayers(4);
                isRun = false;
            }
            view.clearScreen();
        }
    }

    private void chooseUserEnemy() {
        for (int index = 0; index < this.countOfPlayers; index++) {
            view.clearScreen();
            boolean isRun = true;

            while (isRun) {
                String option = view.chooseUserEnemy();

                if (option.equals("1") || option.equals("Y") || option.equals("YES")) {
                    this.isUser.add(true);
                    isRun =false;
                }
                else if (option.equals("2") || option.equals("N") || option.equals("NO")) {
                    this.isUser.add(false);
                    isRun =false;
                }
            }
        }
    }

    private void launchGame() {
        CardsSourceCSV cardSource = new CardsSourceCSV();
        List<List<String>> strCards = cardSource.getCardsDataFromFile("./src/resources/players_20_top200.csv");
        Deck deckOfCards = new Deck(this.countOfCard, strCards);

        if (countOfPlayers == 2) {
            QuarterGame game = new QuarterGame((ArrayList<Card>) deckOfCards.getDeck(), this.isUser, view);
            game.run();
        }
        else if ((countOfPlayers == 3)) {
            QuarterGame game = new QuarterGameForThree((ArrayList<Card>) deckOfCards.getDeck(), this.isUser, view);
            game.run();
        }
        else {
            QuarterGame game = new QuarterGameForFour((ArrayList<Card>) deckOfCards.getDeck(), this.isUser, view);
            game.run();
        }
    }

    private void setCountOfCard(int countOfCard) {
        this.countOfCard = countOfCard;
    }

    public void setCountOfPlayers(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }
}
