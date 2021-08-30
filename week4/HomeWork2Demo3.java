package com.mj.study.week4;

import java.util.concurrent.*;

public class HomeWork2Demo3 {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程，
        // 异步执行 下面方法
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Worker worker = new Worker(countDownLatch);
        worker.start();
        countDownLatch.await();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程

    }

    static class Worker extends Thread {
        private CountDownLatch latch;
        public Worker(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run() {
                int result = sum();
                System.out.println("异步计算结果为："+result);
                latch.countDown();
        }
    }
    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
