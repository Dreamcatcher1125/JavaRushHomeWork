package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным.
Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста.
А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String adress;

    public Cat(String name)
    {
        this.name = name;
        this.weight = 2;
        this.age = 1;
    }

    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = 2;
    }

    public Cat(int weight, String color)
    {
        this.weight = weight;
        this.color = color;
        this.age = 1;
    }

    public Cat(int weight, String color, String adress)
    {
        this.weight = weight;
        this.color = color;
        this.adress = adress;
        this.age = 1;
    }
}
