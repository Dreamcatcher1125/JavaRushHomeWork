package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/*
1. Добавь в интерфейс метод getVacancies(String searchString), который будет возвращать список вакансий.
 */
public interface Strategy {  // Он будет отвечать за получение данных с сайта.
    List<Vacancy> getVacancies(String searchString);
}
