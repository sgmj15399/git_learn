package com.mjstudy.example.school;

import java.util.List;

public class MyClass {
    public MyClass() {
        System.out.println("MyClass init");
    }

    public MyClass(List<Student> students) {
        System.out.println(toString());
    }

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "MyClass::" + students.toString();
    }
}
