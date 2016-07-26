package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
В методе main:
1. Удали создание хардкоженного планшета и вызова его метода createOrder()
2. Создай второго повара
3. Зарегистрируй поваров используя класс StatisticEventManager
4. Для второго повара и всех планшетов расставь зависимость Observer-Observable
5. Создай список объектов-планшетов 5 штук, инициализируйте его в цикле
6. Создай и запустим трэд на основе объекта RandomOrderGeneratorTask
7. Через секунду прерви его и посмотри на вывод в консоль

Уупс, два повара готовят один и тот же заказ 8-О

Такой аутпут получился потому, что Observable информирует всех своих Observer-ов, т.е. планшет направляет свой заказ всем известным ему поварам.
Такое поведение нам не подходит, поэтому будем исправлять его в следующем задании.
*/

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook = new Cook("Amigo");
        Cook cook1 = new Cook("Bender");
        StatisticEventManager.getInstance().register(cook);
        StatisticEventManager.getInstance().register(cook1);
        Waitor waitor = new Waitor();
        cook.addObserver(waitor);
        cook1.addObserver(waitor);
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i));
            tablets.get(i).addObserver(cook);
            tablets.get(i).addObserver(cook1);
        }
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
