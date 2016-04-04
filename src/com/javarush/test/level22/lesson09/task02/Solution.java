package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}`~!
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            if (entry.getValue() != null)
            {
                if (stringBuilder.toString().equals(""))
                    stringBuilder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                else
                    stringBuilder.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }

        }
        return stringBuilder;
    }

    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put(null, null);
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        map.put("male", "men");
        System.out.println(getCondition(map).toString());

    }
}


//country = 'Ukraine' and city = 'Kiev' and name = 'Ivanov' and
//0123456789012345678901234567890123456789012345678901234567890