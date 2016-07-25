package com.javarush.test.level27.lesson15.big01.ad;
/*
Нам понадобится исключение, которое поможет обработать ситуацию, если у нас не будет получаться подобрать рекламные ролики.
1. Создадим unchecked NoVideoAvailableException в пакете ad.
*/

public class NoVideoAvailableException extends RuntimeException {
}
