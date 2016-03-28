package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inFile1 = new FileInputStream(new File(reader.readLine()));
        FileOutputStream outFile2 = new FileOutputStream(new File(reader.readLine()));

        while (inFile1.available() > 0)
        {
            byte[] buffer = new byte[inFile1.available()];
            int count = inFile1.read(buffer);

            for (int i = 0; i < buffer.length / 2 ; i++)
            {
                byte tmp = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = tmp;
            }

            outFile2.write(buffer, 0, count);
        }

        reader.close();
        inFile1.close();
        outFile2.close();
    }
}

