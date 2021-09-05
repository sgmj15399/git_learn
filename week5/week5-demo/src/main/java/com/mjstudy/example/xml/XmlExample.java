package com.mjstudy.example.xml;

import org.springframework.stereotype.Component;

/**
 * xml方式，Bean装配
 * @author minjian
 */
public class XmlExample {
    public XmlExample() {
        System.out.println("XmlExample init");
    }

    public void info() {
        System.out.println("xml info");
    }
}
