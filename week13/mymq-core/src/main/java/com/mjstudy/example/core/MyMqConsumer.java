package com.mjstudy.example.core;

public class MyMqConsumer<T> {

    private final MyMqBroker broker;

    private MyMq myMq;

    public MyMqConsumer(MyMqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.myMq = this.broker.findKmq(topic);
        if (null == myMq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public MyMqMessage<T> poll() throws InterruptedException {
        return myMq.poll();
    }

}
