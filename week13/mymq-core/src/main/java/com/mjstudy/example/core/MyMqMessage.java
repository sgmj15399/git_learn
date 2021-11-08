package com.mjstudy.example.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@AllArgsConstructor
@Data
public class MyMqMessage<T> {

    private HashMap<String,Object> headers;

    private T body;

}
