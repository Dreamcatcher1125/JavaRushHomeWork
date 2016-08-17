package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask {

    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected Object compute() {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork(); // производит асинхронный запуск задачи
            return task.join() // дожидается выполнения задачи и возвращает результат её выполнения
                    + result; // добавляем к стрингу
        }
        return result;
    }
}

