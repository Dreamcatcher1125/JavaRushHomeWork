package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
arg[0]     arg[1]      arg[2]           arg[3]                siZe=4
 id     productName    price        quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        String productName = "";
        for (int i = 1; i < args.length - 2; i++)
            productName = productName + args[i] + " ";

        String trueProductName = setSpaces(productName, 30);  //устанавливаем ограничения productName
        String truePrice = setSpaces(args[args.length - 2], 8);  //устанавливаем ограничения на price
        String trueQuantity = setSpaces(args[1], 4); // устанавливаем ограничения на quantity

        String id = getId(fileName); // Узнаем последний id
        id = setSpaces(id, 8);  //устанавливаем ограничения на id

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true))); // создаем поток printWriter, который
        // записывает данные, при этом данные дозаписываться в конец файла (если параметр равен true), либо файл должен перезаписываться (если false)
        printWriter.println(id + trueProductName + truePrice + trueQuantity); //записываем в последнюю строчку наши значения
        printWriter.close();

    }

    public static String getId(String fileName) throws IOException  //метод получения последнего id
    {
        ArrayList<Long> allIds = new ArrayList<Long>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)); //создаем поток, которые считывает строку файла
        String line;
        Long currentId;

        while ((line = bufferedReader.readLine()) != null) //если линия не пустая
        {
            line = line.substring(0, 8).replaceAll("\\s", ""); // всю линю мы преобазовываем в линию длинной 0,8, т.е. длинной нашего id
            // пробельный символ \\s меняем на ""
            currentId = Long.parseLong(line); //переделываем в long полученное значение line
            allIds.add(currentId); //  добавляем в список
        }
        bufferedReader.close();

        Long maxId = Collections.max(allIds); //узнаем максимальное из списка
        Long MyId = maxId + 1;

        return MyId.toString();
    }


    public static String setSpaces(String previousName, int count)  //метод, который устанавливает область для параметров
    {
        String trueName;

        if (previousName.length() > count) //если букв больше, то нужно просто обрезать
            trueName = previousName.substring(0, count);
        else // если букв меньше, то нужно добить пробелами
        {
            String s = "";
            for (int i = 0; i < (count - previousName.length()); i++)
                s = s + " ";
            trueName = previousName + s;
        }
        return trueName;
    }
}