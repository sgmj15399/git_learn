package com.mj.example;

import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class SubscribeOrder {
    public SubscribeOrder(final JedisPool jedisPool,final String channelName){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start subscriber order");
                Jedis jedis = jedisPool.getResource();
                jedis.subscribe(getJedisPubSub(),channelName);
            }
        },"SubscribeOrderThread").start();
    }

    private JedisPubSub getJedisPubSub() {
        return new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (message.isEmpty()) {
                    System.out.println("subscriber End");
                    System.exit(0);
                }
                System.out.printf("Receive message from %s :: %s\n", channel, message);
            }
        };
    }
}
