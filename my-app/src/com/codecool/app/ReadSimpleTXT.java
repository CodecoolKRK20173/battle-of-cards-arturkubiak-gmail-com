package com.codecool.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadSimpleTXT {

    protected List<String> readLinesFromTxt(String filepath) {
        List<String> allLines = new ArrayList<>();

        try {
            Scanner txtFile = new Scanner(new FileReader(filepath));
            while (txtFile.hasNextLine()) {
                String txtLine = txtFile.nextLine();
                allLines.add(txtLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("TXT file not found!");
        }
        return allLines;
    }
}