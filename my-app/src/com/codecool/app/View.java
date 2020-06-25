package com.codecool.app;

public class View {

    void printMenu() {
        String[] options = {"Start game", "End game"};

        System.out.println("Menu Quartett card game:");

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
}
