package com.mjstudy.example.kafkademo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

public class KafkaUtil {
    public static KafkaConsumer<String, String> createConsumer(String servers, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", servers);
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "false");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList(topic));
        return kafkaConsumer;
    }

    public static void readMessage(KafkaConsumer<String, String> kafkaConsumer, int timeout) {
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(timeout);
            for (ConsumerRecord<String, String> record : records) {
                String value = record.value();
                kafkaConsumer.commitAsync();
                System.out.println("readMessage:"+value);
            }
        }
    }

    public static KafkaProducer<String, String> createProducer(String servers) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", servers);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>(properties);
    }

    public static void send(KafkaProducer<String, String> producer, String topic, String message) {
        producer.send(new ProducerRecord<String, String>(topic, message));
    }
}
