package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код


        Cat tom = new Cat("Том", 6, 25);
        Dog dog = new Dog("Pesik", 25, 100);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы

    public static class Dog
    {
        String name;
        int weight;
        int strenht;

        public Dog(String name, int weight, int strenht)
        {
            this.name = name;
            this.weight = weight;
            this.strenht = strenht;
        }
    }

    public static class Cat
    {
        String name;
        int weight;
        int height;

        public Cat(String name, int weight, int height)
        {
            this.name = name;
            this.weight = weight;
            this.height = height;
        }
    }
}
