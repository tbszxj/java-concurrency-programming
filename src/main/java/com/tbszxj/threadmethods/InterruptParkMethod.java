package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * 打断park方法
 * @author zxj
 * @date 2020/10/18 20:02
 */
@Slf4j
public class InterruptParkMethod {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("park...");
            LockSupport.park();
            log.info("unpark...");
            //log.info("interrupt status {}",Thread.currentThread().isInterrupted());
            log.info("interrupt status {}",Thread.interrupted());
            // 第一次打断后打断标记被设置为真，park方法将失效
            // 解决方法是使用Thread.interrupted()代替Thread.currentThread().isInterrupted()
            LockSupport.park();
            log.info("the second park is disabled");
        });
        thread.start();

        Thread.sleep(2000);
        thread.interrupt();
    }
}
