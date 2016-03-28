package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream defaultStream = System.out;
        ByteArrayOutputStream dinamicStream = new ByteArrayOutputStream();
        PrintStream adapter = new PrintStream(dinamicStream);
        System.setOut(adapter);

        testString.printSomething();

        String result = dinamicStream.toString();

        char[] ch = result.toCharArray();

        result = "";

        for (int i = 0; i <  ch.length; i++)
        {
            if (ch[i] >= '0' && ch[i] <= '9') result += ch[i];
        }

        System.setOut(defaultStream);

        System.out.println(result);

    }


    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
