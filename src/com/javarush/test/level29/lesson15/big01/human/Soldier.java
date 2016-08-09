package com.javarush.test.level29.lesson15.big01.human;

public class Soldier extends Human{
    private String name;
    private int age;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
