package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        RandomAccessFile file1 = new RandomAccessFile(fileName1, "rw");
        RandomAccessFile file2 = new RandomAccessFile(fileName2, "r");

        byte[] buffer1 = new byte[(int) file1.length()];
        file1.read(buffer1);

        file1.seek(0);

        byte[] buffer2 = new byte[(int) file2.length()];
        file2.read(buffer2);

        file1.write(buffer2, 0, buffer2.length);
        file1.write(buffer1, 0, buffer1.length);

        System.out.println(file1.getFilePointer());

        reader.close();
        file1.close();
        file2.close();


    }
}
