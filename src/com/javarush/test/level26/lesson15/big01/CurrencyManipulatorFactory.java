package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;

public final class CurrencyManipulatorFactory {

    static HashMap<String, CurrencyManipulator> manipulatorMap = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        CurrencyManipulator current;

        if (manipulatorMap.containsKey(currencyCode)) {
            return manipulatorMap.get(currencyCode);
        } else {
            current = new CurrencyManipulator(currencyCode);
            manipulatorMap.put(currencyCode, current);
            return current;
        }
    }
}
