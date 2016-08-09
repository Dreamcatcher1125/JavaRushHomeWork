package com.javarush.test.level29.lesson15.big01.human;
/*1
7.1.	Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02()
одним методом incAverageGrade(double delta).
7.4.	Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,
чтобы они вместо набора параметров принимали по одному объекту даты.
*/
import java.util.Date;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta){
        averageGrade += delta;
    }


    public void setAverageGrade (double averageGrade){
        this.averageGrade = averageGrade;
    }

    public void setCourse  (int course){
        this.course = course;
    }

    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}
