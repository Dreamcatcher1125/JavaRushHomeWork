package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Collections;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] m1 = new int[5];
        for (int i = 0; i < m1.length ; i++)
        {
            m1[i] = i;
        }

        int[] m2 = new int[2];
        for (int i = 0; i < m2.length ; i++)
        {
            m2[i] = i;
        }

        int[] m3 = new int[4];
        for (int i = 0; i < m3.length ; i++)
        {
            m3[i] = i;
        }

        int[] m4 = new int[7];
        for (int i = 0; i < m4.length ; i++)
        {
            m4[i] = i;
        }

        int[] m5 = new int[0];
        for (int i = 0; i < m5.length ; i++)
        {
            m5[i] = i;
        }

        Collections.addAll(list,m1,m2,m3,m4,m5);

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
