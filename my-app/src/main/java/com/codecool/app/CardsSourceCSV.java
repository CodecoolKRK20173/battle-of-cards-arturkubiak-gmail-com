package com.codecool.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CardsSourceCSV implements CardsSourceDAO {

    private List<List<String>> loadedCSV = new ArrayList<>();

    @Override
    public List<List<String>> getCardsDataFromFile(String filePath) {
        
        try {
            Scanner inFile = new Scanner(new FileReader(filePath));
            while (inFile.hasNextLine()) {
                List<String> singleRecord = Arrays.asList(inFile.nextLine().split(","));
                this.loadedCSV.add(singleRecord);
            }
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found");
        }

        return loadedCSV;
    }


}