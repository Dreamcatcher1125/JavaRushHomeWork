package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("1) Count = " + count + ". Должно быть 2" + " result: " + String.valueOf(count == 2));

/*        a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        count = getRectangleCount(a);
        System.out.println("2) Count = " + count + ". Должно быть 3" + " result: " + String.valueOf(count == 3));

        a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };
        count = getRectangleCount(a);
        System.out.println("3) Count = " + count + ". Должно быть 1" + " result: " + String.valueOf(count == 1));

        a = new byte[][]{                               //тут косяк
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}

        };
        count = getRectangleCount(a);
        System.out.println("4) Count = " + count + ". Должно быть 3" + " result: " + String.valueOf(count == 3));  // тут косяк


        a = new byte[][]{
                {1, 0, 0,},
                {0, 0, 0,},
                {0, 0, 1,},

        };
        count = getRectangleCount(a);
        System.out.println("5) Count = " + count + ". Должно быть 2" + " result: " + String.valueOf(count == 2));

        a = new byte[][]{
                {1, 1, 0,},
                {0, 0, 0,},
                {0, 1, 1,},

        };
        count = getRectangleCount(a);
        System.out.println("6) Count = " + count + ". Должно быть 2" + " result: " + String.valueOf(count == 2));

        a = new byte[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        count = getRectangleCount(a);
        System.out.println("7) Count = " + count + ". Должно быть 1" + " result: " + String.valueOf(count == 1));

        a = new byte[][]{                      //тут косяк
                {1, 0, 1,},
                {0, 0, 1,},
                {1, 0, 1,},

        };
        count = getRectangleCount(a);
        System.out.println("8) Count = " + count + ". Должно быть 3" + " result: " + String.valueOf(count == 3)); // тут косяк

        a = new byte[][]{
                {0, 0, 0,},
                {0, 0, 0,},
                {0, 0, 0,},

        };
        count = getRectangleCount(a);
        System.out.println("9) Count = " + count + ". Должно быть 0" + " result: " + String.valueOf(count == 0))*/;
    }

    public static int getRectangleCount(byte[][] a)
    {
        int hor = a[0].length; //количество цифр погоризонтали
        int ver = a.length; //количество цифр по вертикали
        int count;
        int verEnd;
        int horEnd;
        int result = 0; //количество прямоугольников

        for (int i = 0; i < ver; i++)
        {
            for (int j = 0; j < hor; j++)
            {
                if (a[i][j] == 1)
                {
                    verEnd = i;
                    horEnd = j;

                    //по вертикали
                    count = i + 1;
                    System.out.println("a[" + count + "][" + j + "]");

                    while (true)
                    {
                        if (count >= ver || (a[count][j] == 0 && count < ver))
                        {
                            verEnd = count - 1;
                            System.out.println("verEnd = " + verEnd);
                            break;
                        }
                        count++;
                        System.out.println("a[" + count + "][" + j + "]");
                    }

                    //по горизонтали
                    count = j + 1;
                    while (true)
                    {
                        if (count >= hor || (a[i][count] == 0 && count < hor))
                        {
                            horEnd = count - 1;
                            System.out.println("horEnd = " + horEnd);
                            break;
                        }
                        count++;
                    }

                    boolean flag = true;
                    for (int p = i; p <= verEnd; p++)
                        for (int q = j; q <= horEnd; q++)
                            if (a[p][q] != 1)
                            {
                                flag = false;
                                break;
                            }

                    if (flag)  //обознаем прямоугольник
                    {
                        System.out.println("startI = " + i);
                        System.out.println("startJ = " + j);
                        System.out.println("endI = " + verEnd);
                        System.out.println("endJ = " + horEnd);

                        for (int p = i; p <= verEnd; p++)  //очищаем
                            for (int q = j; q <= horEnd; q++)
                                a[p][q] = 0;
                        result++;
                    }
                    System.out.println();
                }
            }
        }
        return result;
    }
}

