package com.javarush.test.level27.lesson15.big01;


      /* 5. Не забудьте сразу после создания заказа и вывода информации о нем в консоль (найдите это место в коде) сделать следующее:
        5.1. Установить флаг setChanged()
        5.2. Отправить обсерверу заказ notifyObservers(order);*/


import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable{ // отправляет оповещение повару, создает заказы
    private final int number;
    final static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder(){ // будет создавать заказ из тех блюд, которые выберет пользователь.
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
