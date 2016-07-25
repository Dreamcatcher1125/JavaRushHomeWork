package com.javarush.test.level27.lesson15.big01.kitchen;

    /*. 1. Создадим класс Cook(Повар) в пакете kitchen, он будет готовить. Пусть в конструкторе приходит его имя, которое выводится методом toString.
        */

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer { // он будет готовит, он получает оповещение, он имплементит Observer
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

/*2.4. Добавим нашему повару вывод в консоль этой информации. Пусть теперь выводится аналогичное сообщение:
    Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min*/

    @Override
    public void update(Observable o, Object arg) { // o - Tablet, arg - order
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
    }

}
