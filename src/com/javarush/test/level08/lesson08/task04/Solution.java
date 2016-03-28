package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Бивень", new Date("SEPTEMBER 2 1955"));
        map.put("Робот", new Date("JULY 5 1992"));
        map.put("Киборг", new Date("NOVEMBER 10 2005"));
        map.put("Папаня", new Date("MAY 15 1175"));
        map.put("Нуб", new Date("NOVEMBER 8 2013"));
        map.put("Симафор", new Date("AUGUST 11 1990"));
        map.put("Больший бум", new Date("SEPTEMBER 11 2001"));
        map.put("Техасская резня бензопилой", new Date("October 17 2003"));
        map.put("Ромперстомпер", new Date("JULY 2 1999"));

        //напишите тут ваш код
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8)
            {
                iterator.remove();
            }
        }

    }
}
