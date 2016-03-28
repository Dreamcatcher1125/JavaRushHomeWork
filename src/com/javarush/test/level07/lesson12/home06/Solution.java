package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human granfather1 = new Human("дедушка Иван", true, 78, null, null);
        Human granfather2 = new Human("дедушка Петр", true, 85, null, null);
        Human granmother1 = new Human("бабушка Афоня", false, 79, null, null);
        Human granmother2 = new Human("бабушка Василиса", false, 84, null, null);
        Human father = new Human("отец Василий", true, 45, granfather1,granmother1);
        Human mother = new Human("мама Алиса", false, 44, granfather2,granmother2);
        Human chiildren1 = new Human("сын Николай", true, 12, father, mother);
        Human chiildren2 = new Human("дочь Алёна", false, 15, father, mother);
        Human chiildren3 = new Human("сын Кирилл", true, 18, father, mother);


        System.out.println(granfather1);
        System.out.println(granfather2);
        System.out.println(granmother1);
        System.out.println(granmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(chiildren1);
        System.out.println(chiildren2);
        System.out.println(chiildren3);
    }

    public static class Human
    {
        //напишите тут ваш код

        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
