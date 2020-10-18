package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zxj
 * @date 2020/10/18 12:59
 */
@Slf4j
public class JoinMethod {
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        withoutJoin();

        // 调用join方法等待线程运行结束
        // 如果需要限定等待时间可以调用join(long n)方法
        withJoin();
    }

    private static void withoutJoin() {
        log.info("===============without join method start=================");
        Thread thread = new Thread(() -> {
            log.info("===============with out join thread start===============");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
            num = 10;
        });

        thread.start();
        log.info("result is {}",num);
        log.info("===============without join method stop=================");
    }

    private static void withJoin() throws InterruptedException {
        log.info("===============with join method start=================");
        Thread thread = new Thread(() -> {
            log.info("===============with join thread start===============");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
            num = 20;
        });

        thread.start();
        thread.join();
        log.info("result is {}",num);
        log.info("===============with join method stop=================");
    }
}
