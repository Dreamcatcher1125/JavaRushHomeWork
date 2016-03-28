package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
 Метод read() должен читать данные одного человека.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner reader = new Scanner(new File("d:/1.txt"));
        PersonScanner personScanner = new PersonScannerAdapter(reader);
        System.out.println(personScanner.read());
        personScanner.close();
    }

    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            if (this.scanner.hasNext()) {
                String[] inputArray = this.scanner.nextLine().split(" ");

                Date birthDate = (new GregorianCalendar(
                        Integer.parseInt(inputArray[5])  //год
                        ,Integer.parseInt(inputArray[4]) - 1, //месяц
                        Integer.parseInt(inputArray[3]))) //день
                        .getTime();
                return new Person(inputArray[1],inputArray[2],inputArray[0],birthDate); //потому что такой конструктор у Person
            }
            return null;
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
