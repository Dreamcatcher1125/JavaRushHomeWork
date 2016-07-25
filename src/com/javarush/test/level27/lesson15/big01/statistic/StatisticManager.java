package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
/*
С его помощью будем регистрировать события в хранилище.
*/

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data){
        // TODO
    }
}
