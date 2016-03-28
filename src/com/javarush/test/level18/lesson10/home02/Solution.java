package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int coutChar = 0;
        int countSpace = 0;
        double res = 0;
        FileInputStream in = new FileInputStream(new File(args[0]));

        while (in.available() > 0)
        {
            int data = in.read();
            coutChar++;
            if (data == Integer.valueOf(' ')) countSpace++;
        }
        in.close();

        res = (double) countSpace / coutChar * 100;
        System.out.printf("%.2f", res);

    }
}
