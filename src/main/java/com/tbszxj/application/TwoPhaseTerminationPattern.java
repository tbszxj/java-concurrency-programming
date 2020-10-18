package com.tbszxj.application;

import lombok.extern.slf4j.Slf4j;

/**
 * 两阶段终止设计模式
 * @author zxj
 * @date 2020/10/18 19:46
 */
@Slf4j
public class TwoPhaseTerminationPattern {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.startMonitor();

        Thread.sleep(5000);
        twoPhaseTermination.stopMonitor();
    }
}

@Slf4j
class TwoPhaseTermination {
    private Thread monitor;

    public void startMonitor() {
        monitor = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()) {
                    log.info("善后处理");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.info("执行监控记录");
                } catch (InterruptedException e) {
                    log.error(e.getMessage(),e);
                    // 重新设置打断标记
                    thread.interrupt();
                }
            }
        });

        monitor.start();
    }

    public void stopMonitor() {
        monitor.interrupt();
    }
}
