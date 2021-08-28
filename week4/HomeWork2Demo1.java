package com.mj.study.week4;

import okhttp3.Call;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeWork2Demo1 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        // 在这里创建一个未来任务，
        // 异步执行任务，通过get获取任务执行结果

        FutureTask<Integer> task = new FutureTask<>(new Worker());
        // 启动线程
        new Thread(task).start();
        // 获取结果
        try {
            System.out.println("异步计算结果为："+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程

    }
    static class Worker implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            return sum();
        }
    }
    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
