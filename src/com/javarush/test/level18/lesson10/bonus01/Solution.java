package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:

-e       fileName       fileOutputName
-d       fileName       fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int n = args.length;
        if (n != 3) return;

        int key = 10;

        FileInputStream in = new FileInputStream(new File(args[1]));
        FileOutputStream out = new FileOutputStream(new File(args[2]));


        if (args[0].equals("-e")) //зашифровка
        {
            while (in.available() > 0)
            {
                int data = in.read();
                int dataE = data ^ key;
                out.write(dataE);
            }
        }

        if (args[0].equals("-d")) //расшифровка
        {
            while (in.available() > 0)
            {
                int data = in.read();
                int dataD = data ^ key;
                out.write(dataD);
            }
        }
        in.close();
        out.close();
    }

}
