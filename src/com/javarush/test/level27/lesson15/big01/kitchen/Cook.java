package com.javarush.test.level27.lesson15.big01.kitchen;

/*. 4. Зарегистрируйте событие для повара во время приготовления еды..
 */

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(Observable o, Object arg) { // o - Tablet, arg - order
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

        CookedOrderEventDataRow event = new CookedOrderEventDataRow(o.toString(), this.name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticEventManager.getInstance().register(event);

        setChanged();
        notifyObservers(order);
    }

}
