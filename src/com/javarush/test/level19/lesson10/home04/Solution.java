package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова файл, вид, В
Строки:
В файл собака лошадь
вид В горах

Пример:
words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        String line;
        String[] wordsLine;
        int cout = 0;

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        while ((line = in.readLine()) != null)
        {
            wordsLine = line.split(" ");

            for (int i = 0; i < wordsLine.length ; i++)
            {
                if(words.contains(wordsLine[i])) cout++;
            }
            if(cout == 2) list.add(line);
            cout = 0;
        }
        in.close();

        for (String s : list)
        {
            System.out.println(s);
        }

    }
}
