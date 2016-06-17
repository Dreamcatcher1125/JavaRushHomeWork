package com.javarush.test.level26.lesson15.big01;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        String s = ConsoleHelper.askCurrencyCode();
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s);
        String[] den = ConsoleHelper.getValidTwoDigits(s);
        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(s).addAmount(Integer.parseInt(den[0]),Integer.parseInt(den[1]));
        
    }
}
