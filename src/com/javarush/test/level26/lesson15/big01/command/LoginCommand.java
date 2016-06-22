package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class LoginCommand implements Command {

    private final String number = "123456789012";
    private final String pin = "1234";

    @Override
    public void execute() throws InterruptOperationException {


        ConsoleHelper.writeMessage("Logging in...");
        while (true) {
            ConsoleHelper.writeMessage("Please specify your credit card number and pin code or type 'EXIT' for exiting.");
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();

            if (number.equals(s1)) {
                if (pin.equals(s2))
                    ConsoleHelper.writeMessage(String.format("Credit card [%s] is verified successfully!", s1));
                else {
                    ConsoleHelper.writeMessage(String.format("Credit card [%s] is not verified.", s1));
                    ConsoleHelper.writeMessage("Please try again or type 'EXIT' for urgent exiting");
                    continue;
                }
            } else {
                ConsoleHelper.writeMessage(String.format("Credit card [%s] is not verified.", s1));
                ConsoleHelper.writeMessage("Please specify valid credit card number - 12 digits, pin code - 4 digits.");
                continue;
            }

            break;
        }

    }
}


