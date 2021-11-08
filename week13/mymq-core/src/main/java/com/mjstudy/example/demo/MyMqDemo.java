package com.mjstudy.example.demo;

import com.mjstudy.example.core.MyMqBroker;
import com.mjstudy.example.core.MyMqConsumer;
import com.mjstudy.example.core.MyMqMessage;
import com.mjstudy.example.core.MyMqProducer;

import lombok.SneakyThrows;

public class MyMqDemo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "mymq.test";
        MyMqBroker broker = new MyMqBroker();
        broker.createTopic(topic);

        MyMqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);
        final boolean[] flag = new boolean[1];
        flag[0] = true;
        new Thread(() -> {
            while (flag[0]) {
                MyMqMessage<Order> message = null;
                try {
                    message = consumer.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(null != message) {
                    System.out.println(message.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();

        MyMqProducer producer = broker.createProducer();
        for (int i = 0; i < 100; i++) {
            Order order = new Order(100L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
            producer.send(topic, new MyMqMessage(null, order));
        }
        Thread.sleep(500);
        System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");
        while (true) {
            char c = (char) System.in.read();
            if(c > 20) {
                System.out.println(c);
                producer.send(topic, new MyMqMessage(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
            }

            if( c == 'q' || c == 'e') break;
        }

        flag[0] = false;

    }
}
