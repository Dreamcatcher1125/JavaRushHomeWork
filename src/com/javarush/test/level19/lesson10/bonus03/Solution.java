package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
                 17
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>

Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // d:/1.txt
        reader.close();

        ArrayList<String> result = new ArrayList<>(); //сюда буду добавлять все, что найдется по запросу
        ArrayList<Pair> list = new ArrayList<>();

        String text = ""; // текст с которым будем работать

        FileReader in = new FileReader(fileName);
        while (in.ready())
        {
            int data = in.read();
            text += (char) data;
        }
        in.close();

        text = text.replaceAll("\r\n", "");
        String t = args[0];
        String open = "<" + t; //открывающйися тег
        String closing = "</" + t; //закрывающийся тег
        int len = t.length(); // длина тега
        int index1 = 0;

        while ((index1 != -1) && (index1 < text.length())) // ищем все теги (если индекс открывающего тега найдт и он меньше длины текста
        {
            index1 = text.indexOf(open, index1); //индекс начала открывающегося тега
            int index2 = text.indexOf(closing, index1 + len); // индекс конца закрывающегося тега
            int k = index1 + len; // индекс конца открывающегося тега
            if (index2 != -1) //если индекс закрывающегося тега найден
            {
                while (text.substring(k, index2).contains(open))
                {
                    k = index2 + len;
                    index2 = text.indexOf(closing, k);
                }
            }
            if (index1 != -1 && index2 != -1)
            {
                list.add(new Pair(index1, index2));
                index1 += len;
            }
        }

        for (Pair pair : list)
        {
            String str = text.substring(pair.getA(), pair.getB() + len + 3);
            result.add(str);
        }


        for (String s1 : result)
        {
            System.out.println(s1);
        }
    }

    public static class Pair
    {
        private int a;
        private int b;

        public Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        public int getA()
        {
            return a;
        }

        public int getB()
        {
            return b;
        }
    }
}

