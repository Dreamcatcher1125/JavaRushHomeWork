package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties 
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла. 
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties 
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();
    public static Properties pr = new Properties();

    public static void main(String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);
        new Solution().save(new FileOutputStream("d:/1.properties"));
    }

    public void fillInPropertiesMap() throws Exception
    {
//считайте имя файла с консоли и заполните карту properties данными из файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // D:/1.txt
        reader.close();
        InputStream in = new FileInputStream(fileName);
        load(in);
    }

    public void load(InputStream inputStream) throws Exception
    {
        //Реализуйте логику чтения из файла для карты properties.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        pr.load(inputStream); //считываем весь файл настроек
        Set<String> list = pr.stringPropertyNames(); //в list заносим все ключи

        for (String a : list)
            properties.put(a, pr.getProperty(a)); //заполняем map (ключ, значение по ключу)
        bufferedReader.close();
    }

    public void save(OutputStream outputStream) throws Exception
    {
        //Реализуйте логику записи в файл для карты properties.
        PrintWriter printWriter = new PrintWriter(outputStream);
        if (pr.size() > 0)
        {
            pr.putAll(properties); // в Properties помещаем весь map
        }
        pr.store(outputStream, ""); // и записываем в файл
        printWriter.close();
    }
}