package com.javarush.test.level22.lesson18.big01;

public class Field  // поле с клетками
{
    public int width; // ширина
    public int height; // Высота
    public int[][] matrix;  // ячейка с координатами x, y - это matrix[y][x],  "у" - номер строки,  "x" - номер столбца

    public Field(int height, int width)
    {
        this.height = height;
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public int getWidth()
    {
        return width;
    }

    public void print() // объект будет отрисовывать на экран свое текущее состояние
    {

    }

    public void removeFullLines() // будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз
    {

    }

    public Integer getValue(int x, int y) // возвращает значение которое находится в матрице с координатами x и y
    {
        return 0;
    }

    public void setValue(int x, int y, int value) // устанавливает переданное значение в ячейку массива (матрицы) с координатами x, y.
    {

    }
}
