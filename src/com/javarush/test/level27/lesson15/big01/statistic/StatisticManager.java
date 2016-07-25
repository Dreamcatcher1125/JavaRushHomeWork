package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.*;
/*
5. В StatisticManager void register(Cook cook), который зарегистрирует всех поваров.
Просто добавьте поваров в поле класса, тип которого - сет.
*/

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
    private static Set<Cook> setCook = new HashSet<>();

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) { // Он должен регистрировать события в хранилище
        storage.put(data);
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
    }

    public void register(Cook cook){
        setCook.add(cook);
    }
}
