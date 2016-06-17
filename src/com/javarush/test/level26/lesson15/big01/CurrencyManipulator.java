package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator { // будет хранить всю информацию про выбранную валюту

    private String currencyCode; // код валюты, например, USD. Состоит из трех бук
    private Map<Integer, Integer> denominations; // это Map<номинал, количество>

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations == null) denominations = new HashMap<>();
        if (!denominations.containsKey(denomination))
            denominations.put(denomination, count);
        else
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
    }

    public int getTotalAmount()
    {
        int result = 0;
        for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            result = result + (pair.getKey() * pair.getValue());

        return result;
    }

    public boolean hasMoney() {
        return denominations.size() != 0;
    }
}
