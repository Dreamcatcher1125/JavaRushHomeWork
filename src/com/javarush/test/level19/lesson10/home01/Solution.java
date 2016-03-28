package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
           if(map.containsKey(s[0]))
           {
                       d = d + map.get(s[0]);
                       map.put(s[0], d);
           }
           else
           {
               map.put(s[0], d);
           }
       }

        reader.close();

        for (Map.Entry<String, Double> t : map.entrySet())
        {
            String s = t.getKey();
            double d = t.getValue();
            System.out.println(s + " " + d);
        }
    }

}
