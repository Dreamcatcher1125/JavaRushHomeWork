package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
\\p{Punct}
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();  // D:/1.txt
        String fileName2 = reader.readLine();  // D:/2.txt
        reader.close();

        String text = "";
        FileReader in = new FileReader(fileName1);
        while (in.ready())
        {
            int data = in.read();
            text += (char) data;
        }
        in.close();

        text = text.replaceAll("\\p{Punct}", "");

        FileWriter out = new FileWriter(fileName2);
        out.write(text);
        out.close();
    }
}
