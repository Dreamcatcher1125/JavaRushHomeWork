package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

public final class CommandExecutor {
    private static Map<Operation, Command> map = new HashMap<Operation, Command>();

    public CommandExecutor() {
    }

    static {
        CommandExecutor.map.put(Operation.DEPOSIT, new DepositCommand());
        CommandExecutor.map.put(Operation.WITHDRAW, new WithdrawCommand());
        CommandExecutor.map.put(Operation.INFO, new InfoCommand());
        CommandExecutor.map.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) {
        map.get(operation).execute();
    }


}
