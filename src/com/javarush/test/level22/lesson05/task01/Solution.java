package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        System.out.println(string);   // вся строка
        if (string == null)                        //строка пустая - исключение
            throw new TooShortStringException();

        int firstSpace = string.indexOf(" ");  // находим 1-й пробел
        System.out.println(firstSpace);

        if (firstSpace == -1)        // если нет 1го пробела, то исключение
            throw new TooShortStringException();

        int lastSpace = string.indexOf(" ", firstSpace + 1); // следующий пробел(2-ой), начиная от первого + 1
        System.out.println(lastSpace);

        if (lastSpace == -1)          // если нет 2го пробела - исключение
            throw new TooShortStringException();

        lastSpace = string.indexOf(" ", lastSpace + 1); // следующий пробле(3ий), начиная от 2го + 1
        System.out.println(lastSpace);

        if (lastSpace == -1) // если нет 3го - то исключение
            throw new TooShortStringException();

        lastSpace = string.indexOf(" ", lastSpace + 1); // следующий пробел(4ый), начиая от 3го + 1
        System.out.println(lastSpace);

        if (lastSpace == -1)   //если нет 4го, то исключение
            throw new TooShortStringException();

        String afterLastSpace = string.substring(lastSpace + 1);  //остаток после 4го(последнего пробела), осталось найти конец слова
        System.out.println(afterLastSpace);

        char[] afterLastSpaceArray = afterLastSpace.toCharArray();
        int index = 0;
        if (!Character.isLetter(afterLastSpaceArray[0])) //проверяет, является ли первый символ буквой, если нет-исключение
            throw new TooShortStringException();

        for (int i = 1; i < afterLastSpaceArray.length; i++)
        {
            if (Character.isLetter(afterLastSpaceArray[i])) //находим конец слова
                index = i;
            else
                break;
        }
        System.out.println(index);
        return string.substring(firstSpace + 1, lastSpace + index + 2);
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}


// 012345678901234567890123456789012345678
// JavaRush - лучший сервис обучения Java.
//         * *      *      *