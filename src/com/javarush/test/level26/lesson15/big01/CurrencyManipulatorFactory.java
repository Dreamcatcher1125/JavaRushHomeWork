package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

public final class CurrencyManipulatorFactory {

    static HashMap<String, CurrencyManipulator> map = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {

        CurrencyManipulator current;

        if (map.containsKey(currencyCode)) {
            return map.get(currencyCode);
        } else {
            current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, current);
            return current;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {

        return map.values();
    }
}
