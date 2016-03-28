package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(200.0, "Двести");
        labels.put(300.0, "Триста");
        labels.put(400.0, "Четыреста");
        labels.put(500.0, "Пятьсот");
        labels.put(600.0, "Шестьсот");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
