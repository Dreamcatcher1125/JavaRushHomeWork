package com.javarush.test.level27.lesson15.big01;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
2. В отдельном классе создай таск(Runnable) RandomOrderGeneratorTask. Этот таск должен:
2.1. Хранить список всех планшетов
2.2. Используя Math.random выбирать случайный планшет.
2.3. У RandomOrderGeneratorTask должен быть только один единственный метод.
2.4. Генерировать случайный заказ каждые ORDER_CREATING_INTERVAL миллисекунд для планшета из п.2.2. (не печатайте стек-трейс)
*/
public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tablets.get((int)(ThreadLocalRandom.current().nextDouble(1) * tablets.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}