package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/


import java.util.ArrayList;

public class Beach implements Comparable<Beach>
{
    public static void main(String[] args)
    {
        ArrayList<Beach> beaches = new ArrayList<Beach>();
        beaches.add(new Beach("b1", 15, 5));
        beaches.add(new Beach("b2", 12, 2));
        beaches.add(new Beach("b3", 11, 4));
        beaches.add(new Beach("b4", 40, 5));
        beaches.add(new Beach("b5",  5, 1));
        beaches.add(new Beach("b6", 45, 1));
        beaches.add(new Beach("b7", 75, 5));
        beaches.add(new Beach("b8", 24, 3));
        beaches.add(new Beach("b9", 20, 2));
        beaches.add(new Beach("b10",30, 4));

        for (Beach x : beaches)
        {
            System.out.println(x.getName() + " " + x.getDistance() + " " + x.getQuality());
        }

    }

    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        float a = this.getQuality()/this.getDistance();
        float b = o.getQuality()/o.getDistance();
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;

    }
}
