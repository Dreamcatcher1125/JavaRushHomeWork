package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

       OutputStream out1 = new FileOutputStream(new File(file1));
        InputStream in2 = new FileInputStream(new File(file2));
        InputStream in3 = new FileInputStream(new File(file3));

        while (in2.available() > 0)
        {

        }
    }
}
