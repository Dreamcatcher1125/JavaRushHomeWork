package com.javarush.test.level27.lesson15.big01.kitchen;

/*
2. Cook(Повар) готовит заказы, а Waitor их обрабатывает. Расставьте правильно Observer и Observable между Waitor и Cook
3. Метод void update пусть выведет в консоль следующее:
order + " was cooked by " + cook
 */

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waitor implements Observer { //официант, он будет относить заказы назад к столику. Официант будет безымянный
    @Override
    public void update(Observable o, Object arg) { // o= cook, arg=order
        Order order = (Order) arg;
        ConsoleHelper.writeMessage(order + " was cooked by " + o);
    }
}
