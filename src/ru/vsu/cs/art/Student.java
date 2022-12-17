package ru.vsu.cs.art;

public class Student {
    String fio;
    String gender;
    int numCourse;
    int middleScore;

    public Student(String fio, String gender, int numCourse, int middleScore) {
        this.fio = fio;
        this.gender = gender;
        this.numCourse = numCourse;
        this.middleScore = middleScore;
    }
}