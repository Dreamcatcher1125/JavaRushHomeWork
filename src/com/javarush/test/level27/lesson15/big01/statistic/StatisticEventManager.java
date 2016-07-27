package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;
/*
7. Из класса StatisticEventManager удали сет поваров, его геттер и метод register(Cook cook)
*/

public class StatisticEventManager {
    private static StatisticEventManager instance = new StatisticEventManager();
    private StatisticStorage storage = new StatisticStorage();



    public static StatisticEventManager getInstance() {
        if (instance == null) {
            instance = new StatisticEventManager();
        }
        return instance;
    }

    private StatisticEventManager() {
    }

    public void register(EventDataRow data) { // Он должен регистрировать события в хранилище
        storage.put(data);
    }


    private static final int[] TIME_FIELDS =
            {
                    Calendar.HOUR_OF_DAY,
                    Calendar.HOUR,
                    Calendar.AM_PM,
                    Calendar.MINUTE,
                    Calendar.SECOND,
                    Calendar.MILLISECOND
            };

    public TreeMap<Date, Long> getAdvertisementRevenueAgregatedByDay() {  /* создайте метод (придумать самостоятельно), который из хранилища достанет все данные,
                                                                            относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.*/
        TreeMap<Date, Long> result = new TreeMap<>();
        for (EventDataRow eventDataRow : storage.getEvents(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow vEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(vEventDataRow.getDate());
            for (int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            Long dayRevenue = result.get(date);
            if (dayRevenue == null) dayRevenue = Long.valueOf(0);
            result.put(date, dayRevenue + vEventDataRow.getAmount());
        }
        return result;
    }

    public TreeMap<Date, HashMap<String, Integer>> getCookWorkloadingAgregatedByDay() {  /* создайте метод (придумать самостоятельно), который из хранилища достанет все данные,
                                                                                            относящиеся к работе повара, и посчитает общую продолжительность работы для каждого покара отдельно.*/
        TreeMap<Date, HashMap<String, Integer>> result = new TreeMap<>();
        for (EventDataRow eventDataRow : storage.getEvents(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookDataRow = (CookedOrderEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(cookDataRow.getDate());
            for (int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            HashMap<String, Integer> cooksNameWorkDuration = result.get(date);
            if (cooksNameWorkDuration == null) {
                cooksNameWorkDuration = new HashMap<>();
                result.put(date, cooksNameWorkDuration);
            }
            String cookName = cookDataRow.getCookName();
            Integer cookWorkDuration = cooksNameWorkDuration.get(cookName);
            if (cookWorkDuration == null) cookWorkDuration = Integer.valueOf(0);
            cooksNameWorkDuration.put(cookName, cookWorkDuration + cookDataRow.getTime());
        }
        return result;
    }


    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> eventMapStorage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                eventMapStorage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            eventMapStorage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType eventType) { // Дополнительно добавьте вспомогательный метод в класс хранилища, чтобы доступиться к данным.
            return eventMapStorage.get(eventType);
        }
    }
}
