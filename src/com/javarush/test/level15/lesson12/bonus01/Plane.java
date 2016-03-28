package com.javarush.test.level15.lesson12.bonus01;

public class Plane implements Flyable
{
    public int passenger;

    public Plane(int passenger)
    {
        this.passenger = passenger;
    }

    @Override
    public void fly()
    {

    }
}
