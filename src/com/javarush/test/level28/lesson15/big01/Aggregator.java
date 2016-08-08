package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;

/*
4. Давай попробуем запустить и посмотреть, как работает наша программа.
В методе main вместо вывода на экран напиши controller.scan();
Воспользуйся подскайкой IDEA и создай метод.
Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.
*/
public class Aggregator {
    public static void main(String[] args) {

        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        controller.scan();
    }
}
