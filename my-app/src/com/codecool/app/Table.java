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

    private enum OptionDeckOfCards {
        TWENTY_FOUR_CARDS, SIXTY_CARDS;
    }

    private enum OptionCountPlayers {
        TWO, THREE, FOUR;
    }
    private enum OptionUser {
        YES, NO;
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
                    view.println("Good bye!");
                    isRun = false;
                    break;
            }
        }
        scan.close();
    }

    private Integer returnOption() {
        int option = 0;

        view.print("Privide number of option: ");

        try {
            option = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.next();
        }
        return option;
    }

    private void chooseOptionOfGame() {
        chooseCountOfCard();
        chooseCountPlayers();
        chooseUserEnemy();
    }

    private void chooseCountOfCard() {
        boolean isRun = true;
        OptionDeckOfCards[] countOfCards = OptionDeckOfCards.values();
        printEnum(countOfCards);

        while (isRun) {
            view.print("Provide` you option: ");
            String option = scan.nextLine().toUpperCase().trim();

            if (option.equals("24") || option.equals("TWENTY") || option.equals("T") || option.equals("1")) {
                setCountOfCard(24);
                isRun = false;
            }
            else if (option.equals("60") || option.equals("SIXTY") || option.equals("T")  || option.equals("2")) {
                setCountOfCard(60);
                isRun = false;
            }
        }
    }

    private void chooseCountPlayers() {
        boolean isRun = true;
        OptionCountPlayers[] countOfPlayers = OptionCountPlayers.values();
        printEnum(countOfPlayers);

        while (isRun) {
            view.print("Provide you option: ");
            String option = scan.nextLine().toUpperCase().trim();

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
        }
    }

    private void chooseUserEnemy() {
        for (int index = 0; index < this.countOfPlayers; index++) {
            view.clearScreen();
            boolean isRun = true;

            while (isRun) {
                OptionUser[] users = OptionUser.values();
                printEnum(users);
                view.println("Enter 'yes' if the player is to be a user. If not, enter 'no'");
                String option = scan.nextLine().toUpperCase().trim();

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

    private void printEnum(Enum[] enumList) {
        for (Enum enumElement : enumList) {
            view.println(enumElement.name());
        }
    }

    private void setCountOfCard(int countOfCard) {
        this.countOfCard = countOfCard;
    }

    public void setCountOfPlayers(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }
}
