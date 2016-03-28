package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        text = text.replaceAll("\\.", "!");

        FileWriter out = new FileWriter(fileName2);
        out.write(text);
        out.close();
    }
}
