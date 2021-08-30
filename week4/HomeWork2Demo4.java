package com.mj.study.week4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class HomeWork2Demo4 {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个许可
        Semaphore semaphore = new Semaphore(1);
        // 创建一个线程异步执行方法计算任务
        Worker worker = new Worker(semaphore);
        worker.start();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程

    }

    static class Worker extends Thread {
        private Semaphore semaphore;
        public Worker(Semaphore semaphore){
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                int result = sum();
                System.out.println("异步计算结果为："+result);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
