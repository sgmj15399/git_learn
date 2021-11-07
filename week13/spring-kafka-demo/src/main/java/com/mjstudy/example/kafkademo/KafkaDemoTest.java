package com.mjstudy.example.kafkademo;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaDemoTest {
    public static void main(String[] args) {
        String servers = "localhost:9001,localhost:9002,localhost:9003";
        String topic = "test32";
        String message = "test kafka";

        KafkaProducer<String, String> producer = KafkaUtil.createProducer(servers);
        KafkaUtil.send(producer, topic, message);

        KafkaConsumer<String, String> consumer = KafkaUtil.createConsumer(servers, topic);
        KafkaUtil.readMessage(consumer, 100);
    }
}
