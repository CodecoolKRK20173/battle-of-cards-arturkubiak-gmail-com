package com.codecool.app;

import java.util.Scanner;

public class View {
    private Scanner scan = new Scanner(System.in);

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

    String getNamePlayer() {
        System.out.print("Provide your name: ");
        return scan.nextLine();
    }

    void pressEnter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press ENTER");
        String pressing = scan.nextLine();
    }
}
