package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        nod(n1,n2);
    }

    private static void nod(int n1, int n2)
    {
        if (n1 > n2) n1 = n1 - n2;
        else n2 = n2 - n1;
        if (n2 == 0)
        {
            System.out.println(n1);
            return;
        }
        nod(n1, n2);
    }
}
