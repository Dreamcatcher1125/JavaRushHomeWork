package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()                  Static block
Static block                        static void init()
public static void main             +public static void main
non-static block                    +non-static block
static void printAllFields          +static void printAllFields
0                                   +0
null                                +null
Solution constructor                +Solution constructor
static void printAllFields          +static void printAllFields
6                                   6
First name                          First name
*/

public class Solution {

    static {                                          //1
        System.out.println("static void init()");
    }

    static {     //2
        init();
    }

    public static void init() {                           //2
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");      //3
        Solution s = new Solution();
    }

    {
        System.out.println("non-static block"); //5
        printAllFields(this);                   //6
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields"); //6, 10
        System.out.println(obj.i);  //7, 11
        System.out.println(obj.name);  //8, 12

    }

    public Solution() {
        System.out.println("Solution constructor"); //9
        printAllFields(this); //10
    }

    public String name = "First name"; // они идентифицировались только в конструкторе
    public int i = 6;

}
