package com.javarush.test.level28.lesson15.big01.model;
/*
4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.
*/
public class Provider {  // Этот класс будет обобщать способ получения данных о вакансиях.
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
