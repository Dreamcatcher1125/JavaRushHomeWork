package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException //управлять всем этим
    {
        for (int i = 0; i < 100 ; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() //будет управлять движением всех лошадей
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print() //отрисовывать их на экран
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }
        System.out.println("");
        System.out.println("");
    }

    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;

    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Цыпа", 3, 0);
        Horse horse2 = new Horse("Дрыпа", 3, 0);
        Horse horse3 = new Horse("Цедрак", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
}
