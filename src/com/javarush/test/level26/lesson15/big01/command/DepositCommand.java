package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.io.IOException;

class DepositCommand implements Command {

    public DepositCommand() {
    }

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("Depositing money");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] moneyAndAmount = ConsoleHelper.getValidTwoDigits(currencyCode);
        try
        {
            int k = Integer.parseInt(moneyAndAmount[0]);
            int l = Integer.parseInt(moneyAndAmount[1]);
            currencyManipulator.addAmount(k, l);
            ConsoleHelper.writeMessage(String.format("%d %s was deposited successfully", k * l, currencyCode));
        } catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage("Please specify valid data.");
        }
    }
}
