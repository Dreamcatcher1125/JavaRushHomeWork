package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        ArrayList<Integer> minList = new ArrayList<>();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            minList.add(data);
        }
        Collections.sort(minList);
        System.out.println(minList.get(0));
        inputStream.close();
    }
}
