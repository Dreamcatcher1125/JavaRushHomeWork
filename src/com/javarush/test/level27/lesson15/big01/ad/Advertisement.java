package com.javarush.test.level27.lesson15.big01.ad;
/*
2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. кидать UnsupportedOperationException, если количество показов не положительное число
2.5.2. уменьшать количество показов
        */
public class Advertisement { // Рекламное объявление
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying; // стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() throws UnsupportedOperationException{
        if (hits <= 0) throw new UnsupportedOperationException();
        hits--;
        if (hits == 1) amountPerOneDisplaying += initialAmount % amountPerOneDisplaying;

    }

    public int getHits() {
        return hits;
    }

    public double getAmountPerSecond() {
        return (double)amountPerOneDisplaying / duration;
    }
}
