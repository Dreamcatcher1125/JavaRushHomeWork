package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;

class ExitCommand implements Command {

    public ExitCommand() {
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do you really want to exit? <y,n>");

        if (ConsoleHelper.readString().equals("y"))
            ConsoleHelper.writeMessage("Thank you for visiting JavaRush cash machine. Good luck.");
    }
}
