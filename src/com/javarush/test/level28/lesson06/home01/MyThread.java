package com.javarush.test.level28.lesson06.home01;
/*MyThread должен:
1. иметь возможность быть созданным используя любой конструктор супер-класса  (Alt+Insert)
        2. приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
        3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше
        максимального приоритета его трэд-группы
*/

public class MyThread extends Thread {

    public static int pr = 0;

    public MyThread() {
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(Runnable target) {
        super(target);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(String name) {
        super(name);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if(pr == 10) pr = 0;
        this.setPriority(++pr);
    }


}
