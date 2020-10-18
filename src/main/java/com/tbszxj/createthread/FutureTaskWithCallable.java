package com.tbszxj.createthread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
@Slf4j
public class FutureTaskWithCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                log.info("running...");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread thread = new Thread(task);
        thread.start();

        // 主线程获取future线程执行结果
        Integer integer = task.get();
        log.info("thread result is : {}", integer);

    }
}
