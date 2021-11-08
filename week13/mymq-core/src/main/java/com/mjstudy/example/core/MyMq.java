package com.mjstudy.example.core;

public final class MyMq {

    public MyMq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new MyBlockingQueue(capacity);
    }

    private String topic;

    private int capacity;

    private MyBlockingQueue<MyMqMessage> queue;

    public boolean send(MyMqMessage message) throws InterruptedException {
        return queue.enQueue(message);
    }

    public MyMqMessage poll() throws InterruptedException {
        return queue.deQueue();
    }

//    @SneakyThrows
//    public KmqMessage poll(long timeout) {
//        return queue.poll(timeout, TimeUnit.MILLISECONDS);
//    }

}
