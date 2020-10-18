package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取线程的状态，java中有线程有六个状态
 * NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING,TERMINATED
 * @author zxj
 * @date 2020/10/18 11:23
 */
@Slf4j
public class GetStateMethod {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("running...");
            }
        };
        log.info(String.valueOf(thread.getState()));
        thread.start();
        log.info(String.valueOf(thread.getState()));
    }
}
