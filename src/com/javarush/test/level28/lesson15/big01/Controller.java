package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.
*/
public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<Vacancy> list = new ArrayList<>();

        try {
            for (Provider provider : providers) {
                for (Vacancy vacancy : provider.getJavaVacancies("SOME TEXT")) {
                    list.add(vacancy);
                }
            }
        } catch (NullPointerException e) {
        }
        System.out.println(list.size());
    }
}
