package com.javarush.test.level27.lesson15.big01.kitchen;

      /* 3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
        Создайте поле dishes - список блюд. Инициализируйте его в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.

        4. Перепишите метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе
        вывод должен быть аналогичный примеру в порядке добавления блюд. Используйте ConsoleHelper.
        Пример:
        Your order: [Juice, Fish] of Tablet{number=5}*/

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    public Tablet tablet;
    public List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }

    }
}
