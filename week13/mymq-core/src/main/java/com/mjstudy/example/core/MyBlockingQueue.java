package com.mjstudy.example.core;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue<T> {
    private List queueList = new LinkedList<MyMqMessage>();
    private volatile int limit = 10;

    public MyBlockingQueue(int limit){
        this.limit = limit;
    }
    public synchronized boolean enQueue(Object object) throws InterruptedException {
        while(queueList.size() > limit){
            this.wait();
        }
        if(queueList.size() == 0){
            this.notifyAll();
        }
        return queueList.add(object);
    }

    public synchronized MyMqMessage deQueue() throws InterruptedException {
        while(queueList.size() == 0){
            this.wait();
        }
        if(queueList.size() == limit){
            this.notifyAll();
        }
        return (MyMqMessage) queueList.remove(0);
    }
}
