package com.codecool.app;

import java.util.List;

public interface CardsSourceDAO {
    
    public List<List<String>> getCardsDataFromFile(String filePath);

}