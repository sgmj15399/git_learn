package com.mjstudy.example.starter;

import java.util.List;

/**
 * @author minjian
 */
public class MySchool {

    private List<MyClass> myClasses;

    public MySchool(List<MyClass> myClasses) {
        this.myClasses = myClasses;
    }

    @Override
    public String toString() {
        return "MyClass::" + myClasses.toString();
    }
}
