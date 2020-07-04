package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    int boardWidth = 41;
    int choiceBoardWidth = 21;
    String footballTitle = "BATTLE OF CARDS: FOOTBALL";

    public List<String> createFullBoard(ArrayList<Player> players, ArrayList<Card> usedCards) {
        List<String> newBoard = new ArrayList<>();

        newBoard.add(createHorizontalBorderLine(boardWidth));
        newBoard.add(createEmptyLine(boardWidth, "@"));
        newBoard.add(createSingleTextLine(footballTitle, boardWidth, "@"));
        newBoard.add(createEmptyLine(boardWidth, "@"));
        newBoard.add(createHorizontalBorderLine(boardWidth));
        newBoard.add(createEmptyStatLine("^"));
        newBoard.add(createDoubleTextLine(players.get(0).getName().toUpperCase(),
                players.get(1).getName().toUpperCase(), "^"));
        newBoard.add(createDoubleTextLine("deck size: " + players.get(0).getCards().size(),
                "deck size: " + players.get(1).getCards().size(), "^"));
        newBoard.add(createEmptyStatLine("^"));
        newBoard.add(createHorizontalBorderLine(boardWidth));
        newBoard.add(createEmptyStatLine("%"));
        newBoard.add(createDoubleTextLine(usedCards.get(0).getName(), usedCards.get(1).getName(), "%"));
        newBoard.add(createEmptyStatLine("%"));
        newBoard.add(createCardStatLine(usedCards.get(0), usedCards.get(1), 1, "%"));
        newBoard.add(createEmptyStatLine("%"));
        newBoard.add(createCardStatLine(usedCards.get(0), usedCards.get(1), 2, "%"));
        newBoard.add(createEmptyStatLine("%"));
        newBoard.add(createCardStatLine(usedCards.get(0), usedCards.get(1), 3, "%"));
        newBoard.add(createEmptyStatLine("%"));
        newBoard.add(createHorizontalBorderLine(boardWidth));

        if(players.size() == 3) {
            newBoard.add(createEmptyStatLine("^"));
            newBoard.add(createHalfTextLine(players.get(2).getName().toUpperCase(), "^"));
            newBoard.add(createHalfTextLine("deck size: " + players.get(2).getCards().size(), "^"));
            newBoard.add(createEmptyStatLine("^"));
            newBoard.add(createHorizontalBorderLine(boardWidth));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHalfTextLine(usedCards.get(2).getName(), "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHalfCardStatLine(usedCards.get(2), 1, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHalfCardStatLine(usedCards.get(2), 2, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHalfCardStatLine(usedCards.get(2), 3, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHorizontalBorderLine(boardWidth));
        }

        if(players.size() == 4) {
            newBoard.add(createEmptyStatLine("^"));
            newBoard.add(createDoubleTextLine(players.get(2).getName().toUpperCase(),
                    players.get(3).getName().toUpperCase(), "^"));
            newBoard.add(createDoubleTextLine("deck size: " + players.get(2).getCards().size(),
                    "deck size: " + players.get(3).getCards().size(), "^"));
            newBoard.add(createEmptyStatLine("^"));
            newBoard.add(createHorizontalBorderLine(boardWidth));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createDoubleTextLine(usedCards.get(2).getName(), usedCards.get(3).getName(), "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createCardStatLine(usedCards.get(2), usedCards.get(3), 1, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createCardStatLine(usedCards.get(2), usedCards.get(3), 2, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createCardStatLine(usedCards.get(2), usedCards.get(3), 3, "%"));
            newBoard.add(createEmptyStatLine("%"));
            newBoard.add(createHorizontalBorderLine(boardWidth));
        }

        return newBoard;
    }

    public List<String> createChoiceBoard(String name, ArrayList<Card> deck, Card card) {
        List<String> newBoard = new ArrayList<>();

        newBoard.add(createHorizontalBorderLine(choiceBoardWidth));
        newBoard.add(createEmptyLine(choiceBoardWidth, "@"));
        newBoard.add(createSingleTextLine("STAT CHOICE BOARD", choiceBoardWidth, "@"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "@"));
        newBoard.add(createHorizontalBorderLine(choiceBoardWidth));
        newBoard.add(createEmptyLine(choiceBoardWidth, "^"));
        newBoard.add(createSingleTextLine(name.toUpperCase(), choiceBoardWidth, "^"));
        newBoard.add(createSingleTextLine("deck size: " + deck.size(), choiceBoardWidth, "^"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "^"));
        newBoard.add(createHorizontalBorderLine(choiceBoardWidth));
        newBoard.add(createEmptyLine(choiceBoardWidth, "%"));
        newBoard.add(createSingleTextLine(card.getName(), choiceBoardWidth, "%"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "%"));
        newBoard.add(createChoiceStatLine(card, 1, "%"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "%"));
        newBoard.add(createChoiceStatLine(card, 2, "%"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "%"));
        newBoard.add(createChoiceStatLine(card, 3, "%"));
        newBoard.add(createEmptyLine(choiceBoardWidth, "%"));
        newBoard.add(createHorizontalBorderLine(choiceBoardWidth));

        return newBoard;
    }

    private String createHorizontalBorderLine(int width) {
        StringBuilder horizontalBorderLine = new StringBuilder();

        for(int i = 0; i < width; i++) {
            horizontalBorderLine.append("*");
        }

        horizontalBorderLine.append("=");

        return horizontalBorderLine.toString();
    }

    private String createEmptyLine(int width, String filler) {
        StringBuilder headlineEmptyLine = new StringBuilder();

        headlineEmptyLine.append("*");
        for(int i = 0; i < width - 2; i++) {
            headlineEmptyLine.append(filler);
        }
        headlineEmptyLine.append("*");

        headlineEmptyLine.append("=");

        return headlineEmptyLine.toString();
    }

    private String createSingleTextLine(String headline, int width, String filler) {
        int widthWithoutBorders = width - 2;
        StringBuilder headlineLine = new StringBuilder();

        headlineLine.append("*");
        for(int i = 0; i < ((widthWithoutBorders - headline.length()) / 2); i++) {
            headlineLine.append(filler);
        }
        headlineLine.append(headline);
        for(int i = 0; i < (widthWithoutBorders - headline.length() - ((widthWithoutBorders - headline.length()) / 2)); i++) {
            headlineLine.append(filler);
        }
        headlineLine.append("*");

        headlineLine.append("=");

        return headlineLine.toString();
    }

    private String createEmptyStatLine(String filler) {
        StringBuilder playerEmptyLine = new StringBuilder();

        playerEmptyLine.append("*");
        for(int i = 0; i < 19; i++) {
            playerEmptyLine.append(filler);
        }
        playerEmptyLine.append("*");
        for(int i = 0; i < 19; i++) {
            playerEmptyLine.append(filler);
        }
        playerEmptyLine.append("*");

        playerEmptyLine.append("=");

        return playerEmptyLine.toString();
    }

    private String createDoubleTextLine(String leftTextContent, String rightTextContent, String filler) {
        int halfWidthWithoutBorders = (boardWidth - 3) / 2;
        StringBuilder doubleTextLine = new StringBuilder();

        doubleTextLine.append("*");

        for(int i = 0; i < ((halfWidthWithoutBorders - leftTextContent.length()) / 2); i++) {
            doubleTextLine.append(filler);
        }
        doubleTextLine.append(leftTextContent);
        for(int i = 0; i < (halfWidthWithoutBorders - leftTextContent.length() - ((halfWidthWithoutBorders - leftTextContent.length()) / 2)); i++) {
            doubleTextLine.append(filler);
        }

        doubleTextLine.append("*");

        for(int i = 0; i < ((halfWidthWithoutBorders - rightTextContent.length()) / 2); i++) {
            doubleTextLine.append(filler);
        }
        doubleTextLine.append(rightTextContent);
        for(int i = 0; i < (halfWidthWithoutBorders - rightTextContent.length() - ((halfWidthWithoutBorders - rightTextContent.length()) / 2)); i++) {
            doubleTextLine.append(filler);
        }

        doubleTextLine.append("*");

        doubleTextLine.append("=");

        return doubleTextLine.toString();
    }

    private String createCardStatLine(Card leftCard, Card rightCard, int statLineNumber, String filler) {
        StringBuilder statLine = new StringBuilder();

        statLine.append("*%");
        if(statLineNumber == 1) {
            statLine.append("PAC(1)-" + leftCard.getFirst() + "%" + "DRI(4)-" + leftCard.getFourth() + "%");

            statLine.append("*");

            statLine.append("%" + "PAC(1)-" + rightCard.getFirst() + "%" + "DRI(4)-" + rightCard.getFourth());
            statLine.append("%*");
        } else if(statLineNumber == 2) {
            statLine.append("SHO(2)-" + leftCard.getSecond() + "%" + "DEF(5)-" + leftCard.getFifth() + "%");

            statLine.append("*");

            statLine.append("%" + "SHO(2)-" + rightCard.getSecond() + "%" + "DEF(5)-" + rightCard.getFifth());
            statLine.append("%*");
        } else if(statLineNumber == 3) {
            statLine.append("PAS(3)-" + leftCard.getThird() + "%" + "PHY(6)-" + leftCard.getSixth() + "%");

            statLine.append("*");

            statLine.append("%" + "PAS(3)-" + rightCard.getThird() + "%" + "PHY(6)-" + rightCard.getSixth());
            statLine.append("%*");
        }

        statLine.append("=");

        return statLine.toString();
    }

    private String createHalfTextLine(String leftTextContent, String filler) {
        int halfWidthWithoutBorders = (boardWidth - 3) / 2;
        StringBuilder halfTextLine = new StringBuilder();

        halfTextLine.append("*");

        for(int i = 0; i < ((halfWidthWithoutBorders - leftTextContent.length()) / 2); i++) {
            halfTextLine.append(filler);
        }
        halfTextLine.append(leftTextContent);
        for(int i = 0; i < (halfWidthWithoutBorders - leftTextContent.length() - ((halfWidthWithoutBorders - leftTextContent.length()) / 2)); i++) {
            halfTextLine.append(filler);
        }

        halfTextLine.append("*");

        for(int i = 0; i < halfWidthWithoutBorders; i++) {
            halfTextLine.append(filler);
        }

        halfTextLine.append("*");

        halfTextLine.append("=");

        return halfTextLine.toString();
    }

    private String createHalfCardStatLine(Card leftCard, int statLineNumber, String filler) {
        int halfWidthWithoutBorders = (boardWidth - 3) / 2;
        StringBuilder halfStatLine = new StringBuilder();

        halfStatLine.append("*%");
        if(statLineNumber == 1) {
            halfStatLine.append("PAC(1)-" + leftCard.getFirst() + "%" + "DRI(4)-" + leftCard.getFourth() + "%");

            halfStatLine.append("*");

            for(int i = 0; i < halfWidthWithoutBorders; i++) {
                halfStatLine.append("%");
            }

            halfStatLine.append("*");
        } else if(statLineNumber == 2) {
            halfStatLine.append("SHO(2)-" + leftCard.getSecond() + "%" + "DEF(5)-" + leftCard.getFifth() + "%");

            halfStatLine.append("*");

            for(int i = 0; i < halfWidthWithoutBorders; i++) {
                halfStatLine.append("%");
            }

            halfStatLine.append("*");
        } else if(statLineNumber == 3) {
            halfStatLine.append("PAS(3)-" + leftCard.getThird() + "%" + "PHY(6)-" + leftCard.getSixth() + "%");

            halfStatLine.append("*");

            for(int i = 0; i < halfWidthWithoutBorders; i++) {
                halfStatLine.append("%");
            }

            halfStatLine.append("*");
        }

        halfStatLine.append("=");

        return halfStatLine.toString();
    }

    private String createChoiceStatLine(Card card, int statLineNumber, String filler) {
        StringBuilder choiceStatLine = new StringBuilder();

        choiceStatLine.append("*%");
        if(statLineNumber == 1) {
            choiceStatLine.append("PAC(1)-" + card.getFirst() + "%" + "DRI(4)-" + card.getFourth() + "%");
            choiceStatLine.append("*");
        } else if(statLineNumber == 2) {
            choiceStatLine.append("SHO(2)-" + card.getSecond() + "%" + "DEF(5)-" + card.getFifth() + "%");
            choiceStatLine.append("*");
        } else if(statLineNumber == 3) {
            choiceStatLine.append("PAS(3)-" + card.getThird() + "%" + "PHY(6)-" + card.getSixth() + "%");
            choiceStatLine.append("*");
        }

        choiceStatLine.append("=");

        return choiceStatLine.toString();
    }
}
