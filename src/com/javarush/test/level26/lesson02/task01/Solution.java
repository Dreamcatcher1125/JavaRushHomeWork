package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array); // сортируем по возрастанию (по дефолту)
        final double median;

        if (array.length % 2 == 0) // если четное количество в списке
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        else                      // если не четное количество
            median = array[array.length / 2];

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1 - median) - Math.abs(o2 - median); //удаленность от медианы
                if (value == 0)
                    value = o1 - o2; // Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
                return (int) value;
            }
        };
        Arrays.sort(array, compareByMedian); // сортируем по удаленности от медианы
        System.out.println(median);
        return array;
    }

    public static void main(String[] args) {
        Integer[] mass = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(sort(mass)));
    }
}
