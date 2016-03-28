package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "a";
        Zerg zerg2 = new Zerg();
        zerg2.name = "b";
        Zerg zerg3 = new Zerg();
        zerg3.name = "c";
        Zerg zerg4 = new Zerg();
        zerg4.name = "d";
        Zerg zerg5 = new Zerg();
        zerg5.name = "e";
        Zerg zerg6 = new Zerg();
        zerg6.name = "f";
        Zerg zerg7 = new Zerg();
        zerg7.name = "g";
        Zerg zerg8 = new Zerg();
        zerg8.name = "h";
        Zerg zerg9 = new Zerg();
        zerg9.name = "j";
        Zerg zerg10 = new Zerg();
        zerg10.name = "l";

        Protos protos1 = new Protos();
        protos1.name = "a";
        Protos protos2 = new Protos();
        protos2.name = "b";
        Protos protos3 = new Protos();
        protos3.name = "c";
        Protos protos4 = new Protos();
        protos4.name = "d";
        Protos protos5 = new Protos();
        protos5.name = "e";

        Terran terran1 = new Terran();
        terran1.name = "a";
        Terran terran2 = new Terran();
        terran2.name = "b";
        Terran terran3 = new Terran();
        terran3.name = "c";
        Terran terran4 = new Terran();
        terran4.name = "d";
        Terran terran5 = new Terran();
        terran5.name = "e";
        Terran terran6 = new Terran();
        terran6.name = "f";
        Terran terran7 = new Terran();
        terran7.name = "g";
        Terran terran8 = new Terran();
        terran8.name = "h";
        Terran terran9 = new Terran();
        terran9.name = "j";
        Terran terran10 = new Terran();
        terran10.name = "l";
        Terran terran11 = new Terran();
        terran11.name = "rofl";
        Terran terran12 = new Terran();
        terran12.name = "pius";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}