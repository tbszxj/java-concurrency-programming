package com.tbszxj.threadmethods;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zxj
 * @date 2020/10/18 10:39
 */
@Slf4j
public class StartAndRunMethod {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("running...");
            }
        };
        // run方法仅仅是方法调用不会创建新的线程，可以多次调用
        thread.run();
        // start方法会创建新线程执行方法，只能调用一次
        thread.start();
        log.info("do some other things");
    }
}
