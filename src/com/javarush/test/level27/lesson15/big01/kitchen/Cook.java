package com.javarush.test.level27.lesson15.big01.kitchen;

    /*. 1. Создадим класс Cook(Повар) в пакете kitchen, он будет готовить. Пусть в конструкторе приходит его имя, которое выводится методом toString.
        */

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer { // он будет готовит, он получает оповещение
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /*3.    Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
            -observable - объект, который отправил нам значение
            -arg - само значение, в нашем случае - это объект Order
            На данном этапе мы сымитируем обработку и выведем в консоль "Start cooking - " + order*/

    @Override
    public void update(Observable o, Object arg) { // o - Tablet, arg - order
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
    }
   /* Не забудьте сразу после создания заказа и вывода информации о нем в консоль (найдите это место в коде) сделать следующее:
            5.1. Установить флаг setChanged()
             5.2. Отправить обсерверу заказ notifyObservers(order);*/
}
