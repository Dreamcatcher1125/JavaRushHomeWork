package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // не забыть его закрыть
        ArrayList<String> listName = new ArrayList<String>();
        String s;

        while (!(s = reader.readLine()).equals("end"))
        {
            listName.add(s);
        }

        Collections.sort(listName);  // т.к. в произвольном порядку - нам нужно все отсортировать

        // создаем новый файл, отбрасывая partN
        int n = listName.get(0).lastIndexOf(".");
        String resName = listName.get(0).substring(0, n);

        File resFile = new File(resName);
        resFile.createNewFile();

        //В него переписать все байты из файлов-частей используя буфер.

        FileOutputStream out = new FileOutputStream(resFile);

        for (int i = 0; i < listName.size() ; i++)
        {
            FileInputStream in = new FileInputStream(new File(listName.get(i)));
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            out.write(buffer,0 ,buffer.length);
            in.close();  // Обязательно сразу закрыть, потом хз как их закрыть
        }
        reader.close();
        out.close();
    }
}
