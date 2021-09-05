package com.mjstudy.example.auto;

import org.springframework.stereotype.Component;

/**
 * 自动注解方式，Bean装配
 * @author minjian
 */
@Component
public class AutoWiredExample {
    public AutoWiredExample() {
        System.out.println("AutoWiredExample init");
    }

    public void info() {
        System.out.println("AutoWiredExample info");
    }
}
