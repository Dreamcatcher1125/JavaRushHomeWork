package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream in = new FileInputStream(new File(args[0]));

        TreeMap<Character, Integer> map = new TreeMap<>();

        byte[] data = new byte[in.available()];
        in.read(data);
        char[] c = new String(data).toCharArray();

        for (char ch : c)
        {
            if (map.containsKey(ch))
            {
                int val = map.get(ch) + 1;
                map.put(ch, val);
            } else
            {
                map.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        in.close();

    }
}
