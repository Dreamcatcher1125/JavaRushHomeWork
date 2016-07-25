package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import java.io.IOException;
import java.util.List;

/*
Наведем некоторые рюшечки:
        3. Запустим приложение и сразу введем 'exit'. Вывод получился не очень красивым.
        Сделайте так, что если в заказе нет блюд, то чтобы он не отправлялся повару. Найдите это место и реализуйте логику.
        В классе Order создайте вспомогательный метод  boolean isEmpty(), который будет определять, есть ли какие либо блюда в заказе.
        Подсказка: используйте одноименный метод
*/

public class Order {
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        this.tablet = tablet;
    }

    @Override
    public String toString() {
        if (dishes == null && dishes.isEmpty()) {
            return "";
        } else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }
    
   /* 2.3. Выберите правильное место из п.2.1. и п.2.2. и добавьте метод int getTotalCookingTime(),
    который посчитает суммарное время приготовления всех блюд в заказе.*/
   
   public int getTotalCookingTime(){
       int totalTime = 0;
       for (Dish dish : dishes) {
           totalTime += dish.getDuration();
       }
       return totalTime;
   }
}
