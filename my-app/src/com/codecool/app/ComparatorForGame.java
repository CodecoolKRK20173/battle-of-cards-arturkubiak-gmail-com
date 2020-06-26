package com.codecool.app;

import java.util.Comparator;

public class ComparatorForGame implements Comparator<Object> {
    enum FightResult {
        FIRST_WIN, SECOND_WIN, THIRD_WIN, FOURTH_WIN, WAR_1_2, WAR_1_3, WAR_1_4, WAR_2_3,
        WAR_2_4, WAR_3_4, WAR_1_2_3, WAR_1_2_4, WAR_1_3_4, WAR_2_3_4, WAR_1_2_3_4;
    }

    @Override
    public int compare(Object o1, Object o2) {

        if (o1.toString().length() > o2.toString().length()) {
            return FightResult.FIRST_WIN.ordinal();
        }
        else if (o1.toString().length() == o2.toString().length()) {
            return FightResult.WAR_1_2.ordinal();
        }
        else {
            return FightResult.SECOND_WIN.ordinal();
        }
    }

    public int compare(Object o1, Object o2, Object o3) {
        return 0;
    }

    public int compare(Object o1, Object o2, Object o3, Object o4) {
        return 0;
    }
}
