package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Василий");
        map.put("Канибалов", "Кирилл");
        map.put("Рогожин", "Роман");
        map.put("Суворов", "Роман");
        map.put("Роландов", "Роман");
        map.put("Синяков", "Николай");
        map.put("Сурков", "Василий");
        map.put("Курочкин", "Андрей");
        map.put("Романов", "Павел");
        map.put("Сидоров", "Кирилл");
        return  map;


    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код

        ArrayList<String> arrayList = new ArrayList<String>(map.values());
        for (int i=0; i<arrayList.size()-1; i++){
            int count=0;
            for (int j=i+1; j<arrayList.size();j++){
                if (arrayList.get(i).equals(arrayList.get(j))) count++;
            }
            if (count>0)removeItemFromMapByValue(map, arrayList.get(i));
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
