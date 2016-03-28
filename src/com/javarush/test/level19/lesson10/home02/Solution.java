package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1) return;

        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready())
        {
            String s[] = reader.readLine().replaceAll("\\s", " ").split(" ");
            double d = Double.parseDouble(s[1]);
            if (map.containsKey(s[0]))
            {
                d = d + map.get(s[0]);
                map.put(s[0], d);
            } else
            {
                map.put(s[0], d);
            }
        }

        reader.close();

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() > max)
                max = entry.getValue();
        }

        ArrayList<String> theRichest = new ArrayList<String>();
        for (Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() == max)
                theRichest.add(entry.getKey());
        }

        for (String aString : theRichest)
            System.out.print(aString + " ");
    }
}
