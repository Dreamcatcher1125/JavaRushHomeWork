package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Пушистиков","Морфей");
        map.put("Наволочкин","Кирилл");
        map.put("Иванов","Сергей");
        map.put("Петров","Кирилл");
        map.put("Сидоров","Костя");
        map.put("Раков","Морфей");
        map.put("Иванова","Наталья");
        map.put("Петрова","Настя");
        map.put("Сидорова","Катя");
        map.put("Ичпочмакова","Екатерина");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (name.equals(pair.getValue())) count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        int count = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            if (familiya.equals(pair.getKey())) count++;
        }

        return count;

    }
}
