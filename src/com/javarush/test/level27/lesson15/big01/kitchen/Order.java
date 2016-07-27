package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import java.io.IOException;
import java.util.List;

/*
Подсказка:
а) создай класс TestOrder - наследник Order - в пакете родителя.
б) в классе Order создай protected метод initDishes(), в котором инициализируй dishes. Вызови этот метод в конструкторе
в) сделай поле dishes protected
г) переопредели initDishes в классе-наследние TestOrder. Сделай инициализацию случайным набором блюд.
д) вместо создания объекта Order в методе createTestOrder() класса Tablet, создавай объект класса TestOrder.
 Весть другой функционал метода createTestOrder оставь прежним

3. Отрефакторь методы createTestOrder() и createOrder(): в одном из методов выдели код, который повторяется в обоих методах,
и наждм Ctrl+Alt+M, введи любое имя метода и нажми ОК. IDEA предложит заменить этот код во втором методе, подтверди.
*/

public class Order {
    private Tablet tablet;
    protected List<Dish> dishes;
    private Cook cookedBy;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
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

    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setCookedBy(Cook cook) {
        this.cookedBy = cookedBy;
    }

    public Cook getCookedBy() {
        return cookedBy;
    }
}
