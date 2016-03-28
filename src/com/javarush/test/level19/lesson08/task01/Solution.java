package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream trueStream = System.out;
        ByteArrayOutputStream dinamicStream = new ByteArrayOutputStream();
        PrintStream adapter = new PrintStream(dinamicStream);
        System.setOut(adapter);

        testString.printSomething();

        String result = dinamicStream.toString();
        result = result.toUpperCase();

        System.setOut(trueStream);

        System.out.println(result);
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's a text for testing");
        }
    }
}
