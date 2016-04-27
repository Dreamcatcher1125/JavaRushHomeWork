package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution
{

    public static boolean checkTelNumber(String telNumber)
    {
        String temp = telNumber;
        int length = temp.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]"))
        {
            return false;
        }
        if (length == 12)
        {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        } else if (length == 10)
        {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        return false;
    }

    public static void main(String[] args)
    {
        String s1 = "+380501234567";
        String s2 = "+38(050)1234567";
        String s3 = "+38050123-45-67";
        String s4 = "050123-4567";
        String s5 = "+38)050(1234567";
        String s6 = "+38(050)1-23-45-6-7";
        String s7 = "050ххх4567";
        String s8 = "050123456";
        String s9 = "(0)501234567";
        System.out.println(s1 + " : " + checkTelNumber(s1) +
                "\n" + s2 + " : " + checkTelNumber(s2) +
                "\n" + s3 + " : " + checkTelNumber(s3) +
                "\n" + s4 + " : " + checkTelNumber(s4) +
                "\n" + s5 + " : " + checkTelNumber(s5) +
                "\n" + s6 + " : " + checkTelNumber(s6) +
                "\n" + s7 + " : " + checkTelNumber(s7) +
                "\n" + s8 + " : " + checkTelNumber(s8) +
                "\n" + s9 + " : " + checkTelNumber(s9));
    }

}
