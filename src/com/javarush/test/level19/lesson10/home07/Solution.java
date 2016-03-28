package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if(args.length != 2) return;

        String fileName1 = args[0]; // d:/1.txt
        String fileName2 = args[1]; // d:/2.txt

        String[] text;
        String line;
        boolean b;
        ArrayList<String> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(fileName1));

        while ((line = in.readLine()) != null)
        {
            text = line.replaceAll("\\s"," ").split(" ");

            for (int i = 0; i < text.length ; i++)
            {
                b = checkCount(text[i], 6);
                if (b == true)
                {
                    list.add(text[i]);
                }
            }
        }
        in.close();

        String result = "";
        for (int i = 0; i < list.size() ; i++)
        {
            if (i == list.size() - 1)
            {
                result += list.get(i);
            }
            else
            {
                result += list.get(i) + ",";
            }
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(fileName2));
        out.write(result);
        out.close();

    }

    private static boolean checkCount(String s, int n)
    {
        char[] ch = s.toCharArray();
        if (ch.length > n) return true;
        else return false;
    }
}
