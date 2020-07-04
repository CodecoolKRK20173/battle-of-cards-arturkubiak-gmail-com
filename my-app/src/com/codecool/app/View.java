package com.codecool.app;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scan = new Scanner(System.in);

    private enum OptionDeckOfCards {
        TWENTY_FOUR_CARDS, SIXTY_CARDS;
    }

    private enum OptionCountPlayers {
        TWO, THREE, FOUR;
    }

    private enum OptionUser {
        YES, NO;
    }

    void printMenu() {
        String[] options = {"Start game", "BoC: Football - rules", "End game"};

        System.out.println(("Menu Quartett card game:").toUpperCase());

        for (int index = 0; index < options.length; index++) {
            System.out.println(String.format("%d. %s", index + 1, options[index]));
        }
    }

    void print(String str) {
        System.out.print(str);
    }

    void println(String str) {
        System.out.println(str);
    }

    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    String getNamePlayer(int playerIndex) {
        clearScreen();
        System.out.print("Player number " + playerIndex + " name (user player): ");
        return scan.nextLine();
    }

    void pressEnter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press ENTER");
        String pressing = scan.nextLine();
    }

    int getOption() {
        System.out.print("Provide number of option: ");
        return scan.nextInt();
    }

    String chooseCountOfCard() {
        OptionDeckOfCards[] countOfCards = OptionDeckOfCards.values();
        printEnum(countOfCards);
        System.out.print("Provide you option: ");
        return scan.nextLine().toUpperCase().trim();
    }

    String chooseCountPlayers() {
        OptionCountPlayers[] countOfPlayers = OptionCountPlayers.values();
        printEnum(countOfPlayers);
        print("Provide you option: ");
        return scan.nextLine().toUpperCase().trim();
    }

    String chooseUserEnemy() {
        OptionUser[] users = OptionUser.values();
        // printEnum(users);
        System.out.println("Press Y or 1 to set up a new user player, N or 2 to set new CPU player: ");
        return scan.nextLine().toUpperCase().trim();
    }

    void printEnum(Enum[] enumList) {
        for (Enum enumElement : enumList) {
            System.out.println(enumElement.name());
        }
    }

    void printRules(String filepath) {
        ReadSimpleTXT newTXT = new ReadSimpleTXT();
        List<String> rules = newTXT.readLinesFromTxt(filepath);

        for (String rule : rules) {
            System.out.println(rule);
        }
    }
}