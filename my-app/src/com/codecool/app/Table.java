package com.codecool.app;

import java.util.*;

public class Table {
    private int countOfCard;
    private int countOfPlayers;
    private List<Card> deckOfCards;

    public Table() {
        this.countOfCard = 0;
    }

    private enum OptionDeckOfCards {
        TWENTY_FOUR_CARDS, SIXTY_CARDS;
    }

    private enum OptionCountPlayers {
        TWO, THREE, FOUR;
    }
    private enum OptionEnemy {
        YES, NO;
    }

    void run() {
        boolean isRun = true;
        CardsSourceCSV cardSource = new CardsSourceCSV();
        List<List<String>> strCards = cardSource.getCardsDataFromFile("./src/resources/players_20_top200.csv");
        deckOfCards = new ArrayList<>();

        for (int i = 0; i < strCards.size(); i++) {
            int first = Integer.parseInt(strCards.get(i).get(1));
            int second = Integer.parseInt(strCards.get(i).get(2));
            int third = Integer.parseInt(strCards.get(i).get(3));
            int fourth = Integer.parseInt(strCards.get(i).get(4));
            int fifth = Integer.parseInt(strCards.get(i).get(5));
            int sixth = Integer.parseInt(strCards.get(i).get(6));
            Card card = new Card(strCards.get(i).get(0), first, second, third, fourth, fifth, sixth);
            deckOfCards.add(card);
        }

        Table table = new Table();
        View view = new View();
        Scanner scan = new Scanner(System.in);

        while (isRun) {
            view.clearScreen();
            view.printMenu();

            int option = table.returnOption(view, scan);

            switch (option) {
                case 1:
                    table.chooseOptionOfGame(table, view, scan);
                    table.launchGame(deckOfCards, view, scan);
                    break;
                case 2:
                    view.println("Good bye!");
                    isRun = false;
                    break;
            }
        }
        scan.close();
    }

    private Integer returnOption(View view, Scanner scan) {
        int option = 0;

        view.print("Privide number of option: ");

        try {
            option = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.next();
        }
        return option;
    }

    private void chooseOptionOfGame(Table table, View view, Scanner scan) {
        chooseCountOfCard(table, view, scan);
        chooseCountPlayers(table, view, scan);
    }

    private void chooseCountOfCard(Table table, View view, Scanner scan) {
        boolean isRun = true;
        OptionDeckOfCards[] countOfCards = OptionDeckOfCards.values();
        table.printEnum(countOfCards, view);

        while (isRun) {
            view.print("Provide` you option: ");
            String option = scan.nextLine().toUpperCase().trim();

            if (option.equals("24") || option.equals("TWENTY") || option.equals("T") || option.equals("1")) {
                table.setCountOfCard(24);
                isRun = false;
            }
            else if (option.equals("60") || option.equals("SIXTY") || option.equals("T")  || option.equals("2")) {
                table.setCountOfCard(60);
                isRun = false;
            }
        }
    }

    private void chooseCountPlayers(Table table, View view, Scanner scan) {
        boolean isRun = true;
        OptionCountPlayers[] countOfPlayers = OptionCountPlayers.values();
        table.printEnum(countOfPlayers, view);

        while (isRun) {
            view.print("Provide you option: ");
            String option = scan.nextLine().toUpperCase().trim();

            if (option.equals("TWO") || option.equals("2")) {
                table.setCountOfPlayers(2);
                isRun = false;
            }
            else if (option.equals("THREE") || option.equals("3")) {
                table.setCountOfPlayers(3);
                isRun = false;
            }
            else if (option.equals("FOUR") || option.equals("4")) {
                table.setCountOfPlayers(4);
                isRun = false;
            }
        }
    }

    private void launchGame(List<Card> deckOfCards, View view, Scanner scan) {
        Collections.shuffle(deckOfCards);
        List<Card> deckToGame = new ArrayList<>();

        for (int index = 0; index < countOfCard; index++) {
            deckToGame.add(deckOfCards.get(index));
        }

        if (countOfPlayers == 2) {
            QuarterGame game = new QuarterGame(deckToGame, this.countOfPlayers);
            game.run();
        }
        else if ((countOfPlayers == 3)) {
            view.println("Option is not available. Sorry...");
        }
        else {
            view.println("Option is not available. Sorry...");
        }
    }

    private void printEnum(Enum[] enumList, View view) {
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
