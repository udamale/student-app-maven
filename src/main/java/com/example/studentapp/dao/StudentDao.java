package com.example.studentapp.dao;

import com.example.studentapp.model.Student;

import java.util.List;
import java.util.ArrayList;

public class StudentDao {
    private static List<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }
}

