package com.mjstudy.example.core;

public class MyMqProducer {

    private MyMqBroker broker;

    public MyMqProducer(MyMqBroker broker) {
        this.broker = broker;
    }

    public boolean send(String topic, MyMqMessage message) throws InterruptedException {
        MyMq myMq = this.broker.findKmq(topic);
        if (null == myMq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return myMq.send(message);
    }
}
