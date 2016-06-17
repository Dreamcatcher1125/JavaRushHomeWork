package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        try {
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
        } catch (InterruptOperationException e) {
            CommandExecutor.execute(Operation.EXIT);
            ConsoleHelper.printExitMessage();
        }

    }
}
