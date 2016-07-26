package com.javarush.test.level27.lesson15.big01.kitchen;

/*
Подсказка:
г) переопредели initDishes в классе-наследние TestOrder. Сделай инициализацию случайным набором блюд.
д) вместо создания объекта Order в методе createTestOrder() класса Tablet, создавай объект класса TestOrder.
Весть другой функционал метода createTestOrder оставь прежним
3. Отрефакторь методы createTestOrder() и createOrder(): в одном из методов выдели код, который повторяется в обоих методах,
и наждм Ctrl+Alt+M, введи любое имя метода и нажми ОК. IDEA предложит заменить этот код во втором методе, подтверди.
*/

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = new ArrayList<>();
        dishes.addAll(Arrays.asList(Dish.values()));
        int randDishCount = (int) (ThreadLocalRandom.current().nextDouble(1) * Dish.values().length) + 1;
        int countOfDishToDelete = dishes.size() - randDishCount;
        for (int i = 0; i < countOfDishToDelete; i++) {
            dishes.remove((int) (ThreadLocalRandom.current().nextDouble(1) * dishes.size()));
        }
    }
}

