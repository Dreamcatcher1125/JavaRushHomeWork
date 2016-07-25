package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) { // для вывода message в консоль
        System.out.println(message);
    }

    public static String readString() throws IOException { //  для чтения строки с консоли
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException { //просит пользователя выбрать блюдо и добавляет его в список. Введенное 'exit' означает завершение заказа.
        List<Dish> youOrder = new ArrayList<>();
        String str;
        ConsoleHelper.writeMessage("Please chose your dish: " + Dish.allDishesToString() + ". Enter 'exit' for finish.");

        while (true) {
            str = readString();
            if (str.equals("exit")) {
                break;
            }
            try {
                youOrder.add(Dish.valueOf(str));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Incorrect choice. Please try again.");
            }
        }
        return youOrder;

    }
}
