package com.mjstudy.example.school;

import java.util.List;

public class School {
    public School() {
        System.out.println("School init");
    }

    public School(List<MyClass> myClasses) {
        System.out.println(toString());
    }

    private List<MyClass> myClasses;

    public List<MyClass> getMyClasses() {
        return myClasses;
    }

    public void setMyClasses(List<MyClass> myClasses) {
        this.myClasses = myClasses;
    }

    @Override
    public String toString() {
        return "MyClass::" + myClasses.toString();
    }
}
