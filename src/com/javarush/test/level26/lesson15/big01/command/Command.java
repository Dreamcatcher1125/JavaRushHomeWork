package com.javarush.test.level26.lesson15.big01.command;

import java.io.IOException;

interface Command {
    void execute() throws IOException;
}
