package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
                                             0                  1
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2) return;
        String fileName1 = args[0];  // D:/1.txt
        String fileName2 = args[1];  // D:/2.txt

        BufferedReader in = new BufferedReader(new FileReader(fileName1));
        String line;
        String[] wordsLine;
        ArrayList<String> list = new ArrayList<>();

        while ((line = in.readLine()) != null)
        {
            wordsLine = line.split(" ");
            for (int i = 0; i < wordsLine.length ; i++)
            {
                char[] ch = wordsLine[i].toCharArray();

                boolean b = checkString(ch);

                if (b == true)
                {
                    list.add(wordsLine[i]);
                }
            }
        }
        in.close();

        FileWriter out = new FileWriter(new File(fileName2));
        for (String s : list)
        {
            out.write(s + " ");
        }
        out.close();

    }

    private static boolean checkString(char[] ch)
    {
        for (int i = 0; i < ch.length ; i++)
        {
            if(ch[i] >= '0' && ch[i] <= '9') return true;
        }
        return false;
    }
}
