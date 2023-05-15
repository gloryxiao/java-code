package com.sean.base.unit;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

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

    @Test
    public void testReentrantLock() {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            if (lock.tryLock()) {  // try lock 立即返回，不加等待队列
                log.info("thread: {}, get lock", Thread.currentThread().getName());
            }

            assert lock.isHeldByCurrentThread();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                log.info("err.", e);
            }

            log.info("thread: {}, release lock", Thread.currentThread().getName());
            lock.unlock();
        });

        Thread t2 = new Thread(() -> {
            if (lock.tryLock()) {
                log.info("thread: {}, get lock", Thread.currentThread().getName());
            }

            assert lock.isHeldByCurrentThread();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                log.info("err.", e);
            }

            log.info("thread: {}, release lock", Thread.currentThread().getName());
            lock.unlock();
        });

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                    log.info("thread: {}, get lock", Thread.currentThread().getName());
                    assert lock.isHeldByCurrentThread();
                    TimeUnit.SECONDS.sleep(3);
                } catch(Exception e){
                    log.info("err.", e);
                } finally {
                    log.info("thread: {}, release lock", Thread.currentThread().getName());
                    lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            log.error("main err", e);
        }

        log.info("main end");
    }

    private volatile int count = 0;

    @Test
    public void testReLockCondition() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 3 == 0) {
                        log.info("thread：{}， count: {}", Thread.currentThread().getName(), count);
                        count ++;
                    }
                    log.info("thread：{}， count: {}, noop", Thread.currentThread().getName(), count);

                    TimeUnit.SECONDS.sleep(1);
                    condition.signal();
                    condition.await();
                    }
                } catch (Exception e) {
                    log.info("err.", e);
                } finally {
                    log.info("thread: {}, release lock", Thread.currentThread().getName());
                    condition.signal();
                    lock.unlock();
                }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 3 == 1) {
                        log.info("thread：{}， count: {}", Thread.currentThread().getName(), count);
                        count ++;
                    }
                    log.info("thread：{}， count: {}, noop", Thread.currentThread().getName(), count);

                    TimeUnit.SECONDS.sleep(1);
                    condition.signal();
                    condition.await();
                }

            } catch (Exception e) {
                log.info("err.", e);
            } finally {
                log.info("thread: {}, release lock", Thread.currentThread().getName());
                condition.signal();
                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 3 == 2) {
                        log.info("thread：{}， count: {}", Thread.currentThread().getName(), count);
                        count ++;

                    }
                    log.info("thread：{}， count: {}, noop", Thread.currentThread().getName(), count);
                    TimeUnit.SECONDS.sleep(1);
                    condition.signal();
                    condition.await();
                }
            } catch (Exception e) {
                log.info("err.", e);
            } finally {
                log.info("thread: {}, release lock", Thread.currentThread().getName());
                condition.signal();
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            log.error("main err", e);
        }

        log.info("main end");
    }
}
