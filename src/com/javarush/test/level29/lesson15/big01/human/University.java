package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

/*
6.2.	Добавление параметра. Добавить параметр с типом double в метод
getStudentWithAverageGrade(), чтобы было понятно с каким средним балом нужен студент.
Реализуй метод getStudentWithAverageGrade().
6.3.	Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
Реализуй этот метод, он должен возвращать студента с максимальным средним балом.
6.4.	Разделение запроса и модификатора. Раздели метод
getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и
void expel(Student student). Первый метод должен возвратить студента с
минимальным средним балом, а второй - отчислить переданного студента (удалять из
списка students).
*/
public class University {

    private List<Student> students = new ArrayList<>();

    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        int index = 0;

        for (int i = 0; i < students.size(); i++ ) {
            if (averageGrade == students.get(i).getAverageGrade()) {
                index = i;
                break;
            }
        }
        return students.get(index);
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = 0;
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > maxGrade) {
                maxGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }

        return students.get(index);
    }

    public Student getStudentWithMinAverageGrade() {

        double minGrade = 100;
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minGrade) {
                minGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }

        return students.get(index);
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
