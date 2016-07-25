package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/*
2.3. VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
     optimalVideoSet - список видео-роликов, отобранных для показа
     amount - сумма денег в копейках
     totalDuration - общая продолжительность показа отобранных рекламных роликов
*/
public class VideoSelectedEventDataRow  implements EventDataRow {
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }
   /* public Date getDate() {
        return currentDate;
    }

    public int getTime() {
        return totalDuration;
    }

    public long getAmount() {
        return amount;
    }

    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }*/
}
