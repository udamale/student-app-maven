package com.example.studentapp.model;

public class Student {
    private int roll;
    private String name;
    private String studentClass;

    public Student() {}

    public Student(int roll, String name, String studentClass) {
        this.roll = roll;
        this.name = name;
        this.studentClass = studentClass;
    }

    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}

