package com.sean.base;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Unsafe 必须使用在系统的装载类中，否则会抛出异常
 * JUC中封装的LockSupport可以使用来停止/授权 线程起停
 */

@Log4j2
public class JUCTest {

    @Test
    public void testParkUnparkFunc() {
        Thread t = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                log.info("[testParkUnparkFunc], echo: {}", i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {

                }

                if (i == 1)
                    LockSupport.park();
            }
        });

        t.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {

        }

        LockSupport.unpark(t);
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
