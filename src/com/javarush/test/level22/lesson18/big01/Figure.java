package com.javarush.test.level22.lesson18.big01;

public class Figure  // класс, который описывает падающую фигуру
{
    public int x;
    public int y;
    public int[][] matrix;  // Двумерный массив 3x3, состоящий из единиц и нулей. Единицей мы обозначаем что клетка есть, нулем - что она пустая.

    public Figure(int x, int y, int[][] matrix)
    {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void left() // для движения фигурки влево.
    {

    }

    public void right() // для движения фигурки вправо.
    {

    }

    public void down() // для движения фигурки вниз
    {

    }

    public void up() // для движения фигурки вверх
    {

    }

    public void downMaximum() // падение фигурки в низ до дна
    {

    }

    public void rotate() // для поворота фигурки вокруг главной диагонали
    {

    }

   public boolean isCurrentPositionAvailable() // проверка - может ли фигурка быть помещена в текущую позицию.
   {
       return true;
   }

    public void landed() // вызывается, когда фигурка достигла дна или уперлась в другую фигурку
    {

    }
}
