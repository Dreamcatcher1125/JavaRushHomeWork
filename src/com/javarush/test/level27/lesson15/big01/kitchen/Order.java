package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import java.io.IOException;
import java.util.List;

/*
Добавьте геттер для поля dishes в класс Order, используйте его при создании события.
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

   public int getTotalCookingTime(){
       int totalTime = 0;
       for (Dish dish : dishes) {
           totalTime += dish.getDuration();
       }
       return totalTime;
   }

    public List<Dish> getDishes() {
        return dishes;
    }
}
