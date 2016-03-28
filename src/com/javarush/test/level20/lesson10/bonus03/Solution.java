package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same", "poeej", "fulm", "rek", "gsf", "rj", "rrj", "mglp", "jhvok", "orgn");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (Word w : list)
        {
            System.out.println(w);
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> result = new ArrayList<>(); //куда мы будем добавлять результат

        for (String s : words)
        {
            for (int j = 0; j < crossword.length; j++)
                for (int i = 0; i < crossword[0].length; i++)
                {
                    if (E(crossword, s, i, j)) //в одну линию вперед
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i + s.length() - 1, j);
                    }
                    if (W(crossword, s, i, j)) //в одну линию назад
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i - s.length() + 1, j);
                    }
                    if (S(crossword, s, i, j)) //сверху вниз (fulm, rj)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i, j + s.length() - 1);
                    }
                    if (N(crossword, s, i, j)) //снизу вверх (jhvok)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i, j - s.length() + 1);
                    }
                    if (NW(crossword, s, i, j)) // по диагонали снизу вверх, справо налево (home, gsf)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i - s.length() + 1, j - s.length() + 1);
                    }
                    if (NE(crossword, s, i, j)) //по диагонали снизу вверх, слева направо (rek)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i + s.length() - 1, j - s.length() + 1);
                    }
                    if (WS(crossword, s, i, j)) // по диагонали сверху вниз, справо налево (mglp)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i - s.length() + 1, j + s.length() - 1);
                    }
                    if (SE(crossword, s, i, j)) // по диагонали сверху вних слева направо (rj, rrj)
                    {
                        result.add(new Word(s));
                        result.get(result.size() - 1).setStartPoint(i, j);
                        result.get(result.size() - 1).setEndPoint(i + s.length() - 1, j + s.length() - 1);
                    }
                }
        }
        return result;
    }


    private static boolean E(int[][] crossword, String word, int startX, int startY)  //в одну линию вперед
    {
        Boolean result = false;
        if (crossword.length > 0 && crossword[0].length - startX >= word.length())
        {
            for (int i = startX, i2 = 0; i2 < crossword[0].length && i < word.length(); i2++, i++)
            {
                if (crossword[startY][i2]!= word.charAt(i))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean W(int[][] crossword, String word, int startX, int startY) //в одну линию назад
    {
        Boolean result = false;
        if (startX + 1 >= word.length())
        {
            for (int i = startX, i2 = 0; i2 >= 0 && i < word.length(); i2--, i++)
            {
                if (crossword[startY][i2] != word.charAt(i))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean S(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (crossword.length - startY >= word.length())
        {
            for (int i = startY, i2 = 0; i < crossword.length && i2 < word.length(); i++, i2++)
            {
                if (crossword[i][startX] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean N(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (startY + 1 >= word.length())
        {
            for (int i = startY, i2 = 0; i >= 0 && i2 < word.length(); i--, i2++)
            {
                if (crossword[i][startX] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean NW(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (startY + 1 >= word.length() && startX + 1 >= word.length())
        {
            for (int i = startY, j = startX, i2 = 0; i >= 0 && j >= 0 && i2 < word.length(); i--, j--, i2++)
            {
                if (crossword[i][j] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean NE(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (startY + 1 >= word.length() && crossword[0].length - startX >= word.length())
        {
            for (int i = startY, j = startX, i2 = 0; i >= 0 && j < crossword[0].length && i2 < word.length(); i--, j++, i2++)
            {
                if (crossword[i][j] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean WS(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (crossword.length - startY >= word.length() && startX + 1 >= word.length())
        {
            for (int i = startY, j = startX, i2 = 0; i < crossword.length && j >= 0 && i2 < word.length(); i++, j--, i2++)
            {
                if (crossword[i][j] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    private static boolean SE(int[][] crossword, String word, int startX, int startY)
    {
        Boolean result = false;
        if (crossword.length - startY >= word.length() && crossword[0].length - startX >= word.length())
        {
            for (int i = startY, j = startX, i2 = 0; i < crossword.length && j < crossword[0].length && i2 < word.length(); i++, j++, i2++)
            {
                if (crossword[i][j] != word.charAt(i2))
                    return result;
            }

            result = true;
            return result;
        } else
            return result;
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
