package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream defaultStream = System.out;
        ByteArrayOutputStream dinamicStream = new ByteArrayOutputStream();
        PrintStream adapter = new PrintStream(dinamicStream);
        System.setOut(adapter);

        testString.printSomething();

        FileWriter out = new FileWriter(new File(fileName));

        String result = dinamicStream.toString();
        out.write(result);

        System.setOut(defaultStream);

        System.out.println(result);
        out.close();
    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("it's a text for testing");
        }
    }
}

