package com.mjstudy.example.school;

import java.util.HashMap;
import java.util.Map;

public class Student {

    public Student(int id, String name) {
        System.out.println(toString());
    }

    public Student() {
        System.out.println("student init");
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("name", name);
        return "Student::" + map.toString();
    }
}
