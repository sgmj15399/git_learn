package com.mjstudy.example.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MyMqBroker { // Broker+Connection

    public static final int CAPACITY = 10000;

    private final Map<String, MyMq> kmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        kmqMap.putIfAbsent(name, new MyMq(name,CAPACITY));
    }

    public MyMq findKmq(String topic) {
        return this.kmqMap.get(topic);
    }

    public MyMqProducer createProducer() {
        return new MyMqProducer(this);
    }

    public MyMqConsumer createConsumer() {
        return new MyMqConsumer(this);
    }

}
