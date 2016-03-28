package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код

        Map<String, Cat> cats = new HashMap<String, Cat>();
        cats.put("Васька", new Cat("Васька"));
        cats.put("Мурзик", new Cat("Мурзик"));
        cats.put("Шурка", new Cat("Шурка"));
        cats.put("Мотька", new Cat("Мотька"));
        cats.put("Митька", new Cat("Митька"));
        cats.put("Кусака", new Cat("Кусака"));
        cats.put("Забияка", new Cat("Забияка"));
        cats.put("Серый", new Cat("Серый"));
        cats.put("Рыжий", new Cat("Рыжий"));
        cats.put("Голубой", new Cat("Голубой"));

        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Cat>> iterator = map.entrySet().iterator();
        Set<Cat> sety = new HashSet<Cat>();

        while(iterator.hasNext()){
            Cat value = iterator.next().getValue();
            sety.add(value);
        }

        return sety;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
