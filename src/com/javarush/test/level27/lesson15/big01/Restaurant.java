package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

/*3.
3. Чтобы можно было проверить результат, добавим в метод main вызов методов из п.2. в перечисленном порядке.

Нам понадобятся еще некоторые методы.
*/

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5); // объект Observable
        Cook cook = new Cook("Amigo"); // объект Observer для Tablet и в тоже время объект Observable для waitor
        Waitor waitor = new Waitor(); // объект Observer
        tablet.addObserver(cook); // Для объекта Observable добавляем свой объект Observer
        cook.addObserver(waitor); // Для объекта Observable добавляем свой объект Observer
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
