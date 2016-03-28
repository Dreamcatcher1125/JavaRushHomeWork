package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:

0   1     2         3      4                   всего = 5
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

-u 19846 Штанцы демисезонные 123.00 500
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> listString = new ArrayList<>(); // создаем список listString и добавляем в него строки из файла
        ArrayList<Long> listId = new ArrayList<>(); // создаем список listId и добавляем в него все id из файла
        PrintWriter printWriter;

        BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
        String s = "";
        Long currentId;
        while (!((s = in.readLine()) == null))
        {
            listString.add(s);
            s = s.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(s);
            listId.add(currentId);
        }

        int index = listId.indexOf(Long.parseLong(args[1]));  //индекс id который нам прилетает

        if (args[0].equals("-u"))
        {
            String productName = "";
            for (int i = 2; i < args.length - 2; i++)
                productName = productName + args[i] + " ";

            String id = setSpaces(args[args.length - 4], 8);  //устанавливаем ограничения на id
            String trueProductName = setSpaces(productName, 30);  //устанавливаем ограничения productName
            String truePrice = setSpaces(args[args.length - 2], 8);  //устанавливаем ограничения на price
            String trueQuantity = setSpaces(args[args.length - 1], 4); // устанавливаем ограничения на quantity
            String ourString = id + trueProductName + truePrice + trueQuantity; // формируем строку

            if (!listId.contains(Long.parseLong(args[1]))) // если нет такого id
            {
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
                printWriter.println(ourString); //записываем в конце
            } else // если же в списке listID есть такой id
            {
                listString.set(index, ourString); // записываем в список listString на место index нашу строку ourString
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                for (String aString : listString)  //переписываем весль файл
                    printWriter.println(aString);
            }
            printWriter.close();

        } else if (args[0].equals("-d"))
        {
            listString.remove(index); //удаляем из списка listString строку index
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String aString : listString)
                printWriter.println(aString);
            printWriter.close();
        }
        in.close();
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
