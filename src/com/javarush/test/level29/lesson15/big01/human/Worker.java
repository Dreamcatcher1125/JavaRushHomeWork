package com.javarush.test.level29.lesson15.big01.human;
/*
9.3.	Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для
него.
*/
public class Worker extends Human implements Alive{

    private double salary;
    private String company;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
