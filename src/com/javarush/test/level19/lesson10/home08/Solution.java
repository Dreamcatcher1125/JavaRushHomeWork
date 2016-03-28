package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        char[] ch;
        char saveFirst = 'a';
        char saveLast = 'b';
        String result = "";
        while ((line = in.readLine()) != null)
        {
            ch = line.toCharArray();
            int size = ch.length;
            for (int i = 0; i < size / 2; i++)
            {
                saveFirst = ch[i];
                saveLast = ch[size - i - 1];
                ch[i] = saveLast;
                ch[size - i - 1] = saveFirst;
            }

            for (char c : ch)
            {
                result += c;
            }

            System.out.println(result);
            result = "";
        }
        in.close();
    }
}

