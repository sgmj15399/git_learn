package com.mj.study.week4;

import java.util.concurrent.*;

public class HomeWork2Demo2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程池，线程池提交计算任务
        
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> result  = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        executorService.shutdown();
        // 获取结果 
        try {
            System.out.println("异步计算结果为："+result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程

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
