package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
                                    Thread-0
"Thread-0" должно быть заменено на "********"
                                       Thread-4321
"Thread-4321" должно быть заменено на "***********"
т.е. каждая буква имени должны быть заменена на "*"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() //init handler here
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < t.getName().toCharArray().length ; i++)
                {
                    sb.append("*");
                }
                String nameThread = sb.toString();
                String newMessage = e.getMessage().replace(t.getName(), nameThread);
                e = new Exception(newMessage, e);
                System.out.println(e.getMessage());
                t.setName(nameThread);
            }
        };


    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args)
    {
        Thread th = new Thread(new Solution(new TimerTask()
        {
            @Override
            public void run()
            {
                throw new Error();
            }
        }));
        th.start();
    }
}