package com.javarush.test.level27.lesson15.big01.statistic.event;
/*
4. В EventDataRow создайте методы
Date getDate(), реализация которого вернет дату создания записи
int getTime(), реализация которого вернет время - продолжительность
*/

import java.util.Date;

public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
