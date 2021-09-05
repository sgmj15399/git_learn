package com.mjstudy.example.starter;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
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
