package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit"))
        {
            names.add(fileName);
        }

        for (String s : names)
        {
            Thread t = new ReadThread(s);
            t.start();
            t.join();
        }

        reader.close();
    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream in = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();

                while (in.available() > 0)
                {
                    int data = in.read();
                    list.add(data);
                }
                in.close();

                int max = 0;
                int id = 0;

                for (int a = 0; a < list.size(); a++)
                {
                    int count = Collections.frequency(list, list.get(a));

                    if (count > max)
                    {
                        max = count;
                        id = list.get(a);
                    }
                }

                resultMap.put(fileName, id);

            }
            catch (Exception e)
            {
            }
        }
    }
}