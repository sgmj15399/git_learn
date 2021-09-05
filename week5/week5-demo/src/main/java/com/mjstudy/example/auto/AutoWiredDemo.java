package com.mjstudy.example.auto;

import org.springframework.stereotype.Component;

/**
 * 自动注解方式，Bean装配
 * @author minjian
 */
public class AutoWiredDemo {
    public AutoWiredDemo() {
        System.out.println("AutoWiredDemo init");
    }

    public void info() {
        System.out.println("AutoWiredDemo info");
    }
}
