package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }



    @Override
    public int hashCode()
    {
        int hash = 37;
        hash = 17* hash + ((first == null) ? 0 : first.hashCode());
        hash = 17* hash + ((last == null) ? 0 : last.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Solution n = (Solution) obj;
        if (first != null ? !first.equals(n.first) : n.first != null)
            return false;
        if (last != null ? !last.equals(n.last) : n.last != null)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
