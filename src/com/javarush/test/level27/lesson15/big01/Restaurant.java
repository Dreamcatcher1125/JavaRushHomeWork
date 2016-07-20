package com.javarush.test.level27.lesson15.big01;
    /*7. Надо начинать тестировать наше приложение.
            Добавьте в main создание планшета и создание заказа - new Tablet(5).createOrder();*/
public class Restaurant {
    public static void main(String[] args) {
        new Tablet(5).createOrder();
        new Tablet(6).createOrder();
    }
}
