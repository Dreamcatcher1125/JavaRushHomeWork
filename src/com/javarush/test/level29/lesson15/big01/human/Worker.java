package com.javarush.test.level29.lesson15.big01.human;
/*
5.2.	Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а
не содержать его.
5.3.	Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего
является этот метод.
*/
public class Worker extends Human implements Alive{

    private double salary;
    public String company;

    public Worker(String name, int age)
    {
        super(name, age);
    }

    public void live() {
        super.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
