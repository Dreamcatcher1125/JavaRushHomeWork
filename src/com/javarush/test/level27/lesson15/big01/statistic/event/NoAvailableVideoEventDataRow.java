package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/*
2.2. NoAvailableVideoEventDataRow(int totalDuration)
     totalDuration - время приготовления заказа в секундах
*/
public class NoAvailableVideoEventDataRow  implements EventDataRow {
    private Date currentDate;
    private int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}