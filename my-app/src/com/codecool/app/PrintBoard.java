package com.codecool.app;

import java.util.List;

public class PrintBoard {
    private List<String> gameBoard;
    /*
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    */

    public PrintBoard(List<String> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void displayBoard() {
        for (int i = 0; i < gameBoard.size(); i++) {
            char[] charList = gameBoard.get(i).toCharArray();

            for (char singleChar : charList) {
                switch (singleChar) {
                    case '*':
                        System.out.print("\u001B[47m" + "  " + "\u001B[0m");
                        break;
                    case '^':
                        System.out.print("  ");
                        break;
                    case '@':
                        System.out.print("\u001B[42m" + "  " + "\u001B[0m");
                        break;
                    case '%':
                        System.out.print("\u001B[42m" + "  " + "\u001B[0m");
                        break;
                    case '=':
                        System.out.print("\n");
                        break;
                    default:
                        if((i < 4) || (i > 10 && i < 20) || (i > 26 && i < 36)) {
                            System.out.print("\u001B[42m" + "\u001B[30m" + " " + singleChar + "\u001B[0m");
                        } else if((i > 4 && i < 10) || (i > 20 && i < 26)) {
                            System.out.print(" " + singleChar);
                        }
                }
            }
        }
    }
}
