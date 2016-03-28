package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream defaultStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream adapter = new PrintStream(byteArrayOutputStream);
        System.setOut(adapter);

        testString.printSomething();

        String result = byteArrayOutputStream.toString().replaceAll("\\s"," ");
        String[] operationList = result.split(" ");

        int a = Integer.valueOf(operationList[0]);
        int b = Integer.valueOf(operationList[2]);
        String operation = operationList[1];
        int c = operation(a, b, operation);;

        result = a + " " + operation + " " + b + " " + operationList[3] + " " + c;

        System.setOut(defaultStream);

        System.out.println(result);

    }

    private static int operation(int a, int b, String operation)
    {
        int c = 0;

        if (operation.equals("+"))
        {
            c = a + b;
        } else if(operation.equals("-"))
        {
            c = a - b;
        }else if(operation.equals("*"))
        {
            c = a * b;
        }

        return c;
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("3 + 6 = ");
        }
    }
}

