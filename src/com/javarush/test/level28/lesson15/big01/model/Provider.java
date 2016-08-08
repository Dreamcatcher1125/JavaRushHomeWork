package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/*
3. Вернись в метод getJavaVacancies класса Provider, реализуй его логику из расчета, что всех данных хватает.
*/
public class Provider {  // Этот класс будет обобщать способ получения данных о вакансиях.
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString){
        return strategy.getVacancies(searchString);
    }
}
