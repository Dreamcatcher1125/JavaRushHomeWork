package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/*
1. Перенеси поле-очередь из OrderManager в Restaurant, сделай ее приватной константой.
2. Добавь поле и сеттер в класс Cook, сразу после создания повара используя созданный сеттер установи ему
константу из п.1. в качестве значения для созданного поля.
6 В методе main создай и запусти трэды на основании тасок Cook
7. Из класса StatisticEventManager удали сет поваров, его геттер и метод register(Cook cook)
8. Сделай класс Cook - таском(Runnable). Перенеси логику из трэда внутри конструктора OrderManager в метод run класса Cook
9. Удали класс OrderManager и в методе main исправь зависимость Observer-Observable
*/

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Locale.setDefault(Locale.ENGLISH);
        Cook cookAmigo = new Cook("Amigo");
        cookAmigo.setQueue(QUEUE);
        /*cookAmigo.setDeliveryQueue(deliveryQueue);*/
        Cook cookDiego = new Cook("Deigo");
        cookDiego.setQueue(QUEUE);
        /*cookDiego.setDeliveryQueue(deliveryQueue);*/
        Waitor waitor = new Waitor();
        /*waitor.setDeliveryQueue(deliveryQueue);*/

        cookAmigo.addObserver(waitor);
        cookDiego.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for(int i = 0;i < 5; i++){
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(QUEUE);
            tablets.add(tablet);
        }

        Thread cookAmigoThread = new Thread(cookAmigo);
        cookAmigoThread.start();
        Thread cookDiegoThread = new Thread(cookDiego);
        cookDiegoThread.start();
        /*Thread waitorThread = new Thread(waitor);
        waitorThread.start();*/

        Thread randomOrderGeneratorTaskThread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        randomOrderGeneratorTaskThread.start();
        try
        {
            Thread.sleep(1000);

        }
        catch (InterruptedException e)
        {

        }

        randomOrderGeneratorTaskThread.interrupt();

        while (!QUEUE.isEmpty()){
            Thread.sleep(1);
        }

        while ((cookAmigo.isBusy())||(cookDiego.isBusy())) { Thread.sleep(1);}
        cookAmigoThread.interrupt();
        cookDiegoThread.interrupt();

        /*while (!deliveryQueue.isEmpty()){
            Thread.sleep(1);
        }
        waitorThread.interrupt();*/

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
