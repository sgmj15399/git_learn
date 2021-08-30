package com.mj.study.week4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class HomeWork2Demo5 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        // 创建一个线程使用CyclicBarrier异步执行方法计算任务
        Worker worker = new Worker(cyclicBarrier);
        worker.start();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程

    }

    static class Worker extends Thread {
        private CyclicBarrier cyclicBarrier;
        public Worker(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try {
                int result = sum();
                System.out.println("异步计算结果为："+result);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
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
