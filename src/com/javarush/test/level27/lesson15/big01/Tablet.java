package com.javarush.test.level27.lesson15.big01;


      /* 5. У нас все завязано на работу с консолью. Однако, при возникновении исключений, наше приложение умрет.
        Чтобы узнать причину - добавим в Tablet статический логгер java.util.logging.Logger, инициализированный именем класса.

        6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
        Запишем в лог "Console is unavailable.". Уровень лога - SEVERE - это самый серьезный уровень, мы не можем работать.*/


import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
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
