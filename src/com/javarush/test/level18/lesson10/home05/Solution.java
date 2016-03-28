package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream in = new FileInputStream(fileName1);
        FileOutputStream out = new FileOutputStream(fileName2);

        byte[] buffer = new byte[in.available()];
        in.read(buffer);
        out.write(getInput(buffer));

        reader.close();
        in.close();
        out.close();
    }

    private static byte[] getInput(byte[] buffer)
    {
        StringBuilder sb = new StringBuilder();
        String[] s = new String(buffer).split(" ");
        byte[] res;
        long[] tmp = new long[s.length];

        for (int i = 0; i < s.length; i++)
        {
            tmp[i] = Math.round(Double.valueOf(s[i]));
        }

        for (long i : tmp)
        {
            sb.append(i);
            sb.append(" ");
        }

        res = sb.toString().getBytes();

        return res;
    }
}
