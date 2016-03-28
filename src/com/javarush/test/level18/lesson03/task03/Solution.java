package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> reslist = new ArrayList<>();
        String res = "";

        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            list.add(data);
        }

        //в count считаем кол-во каждого байта
        int[] count = new int[list.size()];
        for (int i=0; i < list.size(); i++)
        {
            count[i] = 0;
            for (int j = 0; j < list.size();j++)
            {
                if (list.get(i) == list.get(j)) count[i]++;
            }
        }
    //определяем максимум
        int max = Integer.MIN_VALUE;
        for (int h: count)
        {
            if (h > max) max = h;
        }

    //собираем байты с минимумом использования и без повторов
        for (int i = 0; i < list.size(); i++)
        {
            if (!reslist.contains(list.get(i)) && count[i] == max) reslist.add(list.get(i));
        }
        for (int y: reslist)
        {
            res = y + " ";
        }
        System.out.println(res);
        inputStream.close();

    }
}
