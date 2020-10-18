package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zxj
 * @date 2020/10/18 11:26
 */
@Slf4j
public class SleepAndYieldMethod {

    public static void main(String[] args) throws InterruptedException {
        log.info("======================sleep==================");
        sleepMethod();
        log.info("======================yield==================");
        yieldMethod();
    }

    private static void sleepMethod() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(),e);
                }
                log.info("running");
            }
        };
        thread.start();
        log.info("thread state {}", thread.getState());
        // sleep方法，让当前线程休眠指定的时间，休眠结束后线程变成RUNNABLE状态
        Thread.sleep(500);
        log.info("thread state {}", thread.getState());

        Thread.sleep(500);
        log.info("thread state {}", thread.getState());
    }

    private static void yieldMethod(){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(),e);
                }
                log.info("running");
            }
        };
        thread.start();
        log.info("thread state {}", thread.getState());
        // yield，让当前线程从Running进入Runnable就绪状态，然后调度执行其他线程
        Thread.yield();
        log.info("thread state {}", thread.getState());
    }
}
