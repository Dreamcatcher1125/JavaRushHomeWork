package com.javarush.test.level29.lesson15.big01.car;

public class Sedan extends Car {

    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }

    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }
}