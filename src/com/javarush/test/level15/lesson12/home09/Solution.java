package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String afterQuestionMark = url.substring(url.indexOf("?") + 1); // после знака вопроса
        String [] tokens = afterQuestionMark.split("\\&+"); //разбиваем все что после знака ? на массив из String

        ArrayList<String> objList = new ArrayList<String>(); // массив для объектов
        Pattern objMutch = Pattern.compile("^obj=.*"); // поиск "obj=" с помошью Патерна
        for(String a:tokens){  // перебор по массиву token
            if(!a.equals("")){
                Matcher matcher = objMutch.matcher(a); // операция сравнения с "obj="
                if(matcher.find()){ objList.add(a.substring(a.indexOf("=") + 1)); } // Если есть "obj=" добавляем в массив objList все что после "="
                if(a.contains("=")){ System.out.print(a.substring(0,(a.indexOf("="))) + " "); } // вывод на экран с начало и до символа "="
                else {System.out.print(a + " ");} // если нет ни каких символов, то просто выводим на экран
            }
        }
        // теперь нужно из массива objList разбить на Double и на String
        Pattern doublePattern = Pattern.compile("[0-9.]"); // патерн для Double
        Pattern stringPattern = Pattern.compile("[A-Za-z]"); // паттерн для String

        System.out.println();
        for(String a:objList){ //перебор по массиву objList
            Matcher matcher = stringPattern.matcher(a); //производим операцию сравнения для String
            Matcher matcher1 = doublePattern.matcher(a); //производим операцию сравнения для Doble
            if(matcher.find()){alert(a);} //если стринг вызываем alert String
            else  if(matcher1.find()){alert(Double.parseDouble(a));} //если Double вызываем alert Double
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
