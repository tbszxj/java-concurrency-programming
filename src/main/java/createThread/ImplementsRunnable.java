package createThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImplementsRunnable {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                log.info("running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        log.info("running");
    }
}
