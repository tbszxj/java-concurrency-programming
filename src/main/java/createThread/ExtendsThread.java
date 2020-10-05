package createThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtendsThread {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                log.info("running");
            }
        };

        thread.setName("T1");
        thread.start();

        log.info("running");
    }
}
