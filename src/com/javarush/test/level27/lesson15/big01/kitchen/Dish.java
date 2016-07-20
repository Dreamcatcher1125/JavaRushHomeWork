package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

public enum  Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        StringBuilder result = new StringBuilder(Arrays.toString(values()));
        result.delete(result.length() - 1, result.length()); // удаляем последнюю скобочку
        result.delete(0, 1); //удаляем первую скобочку
        return result.toString();
    }
}
