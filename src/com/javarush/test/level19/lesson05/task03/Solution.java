package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader in = new FileReader(fileName1); // d:/1.txt
        FileWriter out = new FileWriter(fileName2); // d:/2.txt

        String text = "";

        while (in.ready())
        {
            int data = in.read();
            text += (char) data;
        }
        in.close();

        text = text.replaceAll("\\s", " ");
        String[] list = text.split(" ");

        for (String s : list)
        {
            if (checkString(s) == true)
            {
                out.write(s + " ");
            }
        }
        out.close();


    }

    public static boolean checkString(String string) // проверка число ли это
    {
        try
        {
            Integer.parseInt(string);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
