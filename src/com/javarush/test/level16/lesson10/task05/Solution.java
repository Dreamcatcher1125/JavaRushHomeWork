package com.javarush.test.level16.lesson10.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.

2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
*/

public class Solution {
    public static byte countThreads = 3;
    static List<Thread> threads = new ArrayList<Thread>(countThreads);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        TimeUnit.SECONDS.sleep(3);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //add your code here - добавь код тут

        for (Thread a : threads)
        {
            a.interrupt();
        }
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < countThreads; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < countThreads; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String commonResource;


        public Water(String commonResource) {
            this.commonResource = commonResource;
        }

        public void run() {
            //fix 2 variables - исправь 2 переменных
            Thread t = Thread.currentThread();
            boolean isCurrentThreadInterrupted = Thread.interrupted();
            String threadName = t.getName();

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + commonResource + ", нить " + threadName);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
