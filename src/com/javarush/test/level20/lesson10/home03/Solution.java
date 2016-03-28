package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable
{
    public static class A
    {
        protected String name = "A";

        public A()
        {
        }

        public A(String name)
        {
            this.name += name;
        }
    }

    public class B extends A implements Serializable //в сигнатуре нет ошибок - тут ничего не трогаем
    {
        public B(String name)
        {
            super(name);
            this.name += name;
        }

        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
        {
            s.defaultReadObject();
            name = (String) s.readObject();
        }

        private void writeObject(ObjectOutputStream s) throws IOException
        {
            s.defaultWriteObject();
            s.writeObject(name);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException //при десериализации имя не восстанавливается
    {
        Solution s = new Solution();
        B b = s.new B("B");
        System.out.println(b.name);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/1.txt"));
        objectOutputStream.writeObject(b);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/1.txt"));
        B b1;
        b1 = (B) objectInputStream.readObject();
        System.out.println("b:    " + b.toString() + " " + b.name);
        System.out.println("bDes: " + b1.toString() + " " + b1.name); //имя b1 не совпадало, нужно переопределять readObject и writeObject
        objectInputStream.close();
    }
}
