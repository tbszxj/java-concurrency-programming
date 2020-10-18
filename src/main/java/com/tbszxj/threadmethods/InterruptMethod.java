package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程在休眠过程中可以调用interrupt方法来打断
 * 被打断的线程抛出InterruptedException异常
 * @author zxj
 * @date 2020/10/18 11:41
 */
@Slf4j
public class InterruptMethod {

    public static void main(String[] args) throws InterruptedException {
        interruptSleepThread();

        interruptRunningThread();
    }

    private static void interruptSleepThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("enter sleep...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info("thread has been interrupted...");
                log.info("interrupt flag is : {}", Thread.currentThread().isInterrupted());
                log.error(e.getMessage(),e);
            }
        });
        thread.start();

        // 主线程休眠500ms后打断thread线程
        Thread.sleep(500);
        log.info("interrupt thread...");
        thread.interrupt();
    }

    private static void interruptRunningThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("enter sleep...");
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    log.info("the thread is interrupted");
                    break;
                }

            }
        });
        thread.start();

        // 主线程休眠500ms后打断thread线程
        Thread.sleep(500);
        log.info("interrupt thread...");
        thread.interrupt();

        log.info("interrupt flag is : {}", thread.isInterrupted());
    }
}
