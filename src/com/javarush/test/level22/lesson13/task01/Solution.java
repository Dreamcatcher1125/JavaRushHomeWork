package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution
{
    public static String[] getTokens(String query, String delimiter)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> tmp = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens())
        {
           tmp.add(stringTokenizer.nextToken());
        }

        String[] result = tmp.toArray(new String[tmp.size()]);
        return result;
    }
}
