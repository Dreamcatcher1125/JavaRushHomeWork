package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:

0   1       2         3          4
-c name     sex       bd                    args.length = 4
-u id      name      sex        bd          args.length = 5
-d id                                       args.length = 2
-i id                                       args.length = 2
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        int n = args.length;
        if (n < 2)
        {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        if (args[0].equals("-c"))
        {
            String name = args[1];
            try
            {
                Date bd = sdf.parse(args[3]);
                if (args[2].equals("м"))
                {
                    allPeople.add(Person.createMale(name, bd));
                    System.out.println(allPeople.size() - 1);
                } else if (args[2].equals("ж"))
                {
                    allPeople.add(Person.createFemale(name, bd));
                    System.out.println(allPeople.size() - 1);
                }
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

        } else if (args[0].equals("-u"))
        {

            try
            {
                int id = Integer.parseInt(args[1]);
                if (id > allPeople.size() - 1)
                {
                    return;
                }
                String name = args[2];
                Date bd = sdf.parse(args[4]);
                if (args[3].equals("м"))
                {
                    Person p = Person.createMale(name, bd);
                    allPeople.set(id, p);
                } else if (args[3].equals("ж"))
                {
                    Person p = Person.createFemale(name, bd);
                    allPeople.set(id, p);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        } else if (args[0].equals("-d"))
        {
            try
            {
                int id = Integer.parseInt(args[1]);
                if (id > allPeople.size() - 1)
                {
                    return;
                }
                allPeople.get(id).setBirthDay(null);
                allPeople.get(id).setName("");
                allPeople.get(id).setSex(null);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        } else if (args[0].equals("-i"))
        {
            try
            {
                int id = Integer.parseInt(args[1]);
                if (id > allPeople.size() - 1)
                {
                    return;
                }
                Person p = allPeople.get(id);
                String sex;
                if (p.getSex() == Sex.FEMALE)
                {
                    sex = "ж";
                } else sex = "м";
                System.out.println(p.getName() + " " + sex + " " + sdf1.format(p.getBirthDay()));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
