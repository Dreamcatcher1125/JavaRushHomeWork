package com.javarush.test.level27.lesson15.big01;


      /*
2.3. Если нет рекламных видео, которые можно показать посетителю, то бросить NoVideoAvailableException,
которое перехватить в оптимальном месте (подумать, где это место) и с уровнем Level.INFO логировать фразу
"No video is available for the order " + order
*/


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable { // отправляет оповещение повару, создает заказы
    private final int number;
    final static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() { // будет создавать заказ из тех блюд, которые выберет пользователь.
        Order order = null;
        try {
            order = new Order(this);
            if (order.isEmpty()) return;
            ConsoleHelper.writeMessage(order.toString());
            setChanged(); // Установить флаг setChanged()
            notifyObservers(order); // Отправить обсерверу заказ

            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
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
