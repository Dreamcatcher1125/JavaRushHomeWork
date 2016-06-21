package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do {
                ConsoleHelper.writeMessage("Пожалуйста выберите операцию:" + " \n" +
                        "INFO" + ": 1;\n" +
                        "DEPOSIT" + ": 2;\n" +
                        "WITHDRAW" + ": 3;\n" +
                        "EXIT" + ": 4");
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e) {

            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
            ConsoleHelper.printExitMessage();
        }
    }
}