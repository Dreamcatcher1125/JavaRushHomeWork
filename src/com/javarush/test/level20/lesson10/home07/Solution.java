package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable
{
    transient private FileOutputStream stream;

    private static final long serialVersionUID = 1L;
    private String file;

    public static void main(String[] args) throws Exception
    {
        Solution s = new Solution("D:/1.txt");
        s.writeObject("хреногубка");
        s.close();

        //save
        FileOutputStream fileOut = new FileOutputStream("D:/2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOut);
        oos.writeObject(s);
        oos.flush();
        oos.close();

        //load
        FileInputStream fileInput = new FileInputStream("D:/2.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInput);
        Solution s2 = (Solution)ois.readObject();
        ois.close();

        s2.writeObject("company");
        s2.close();
    }

    public Solution(String fileName) throws FileNotFoundException //конструктор
    {
        this.file = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException  //сохранение в файл через Solution
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException //Сериализация
    {
        out.defaultWriteObject();
        out.writeObject(file);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException // десериализация
    {
        in.defaultReadObject();
        file = (String) in.readObject();
        stream = new FileOutputStream(file, true);
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }


}

