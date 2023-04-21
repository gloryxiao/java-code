package com.sean.code.base;

import sun.java2d.loops.GraphicsPrimitive;
import sun.net.www.http.HttpClient;

import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author sean
 */
public class ThreadCode {

    public static class Caller implements Callable<Integer> {
        private Integer a;
        private Integer b;

        public Caller(Integer x, Integer y) {
            a = x;
            b = y;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return a + b;
        }
    }

    public static class NumPrinter implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            synchronized(this) {
                while (count < 99) {
                    this.notifyAll();
                    count ++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
//        NumPrinter printer = new NumPrinter();
//        Thread t1 = new Thread(printer);
//        Thread t2 = new Thread(printer);
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (Exception exception) {
//
//        }

        FutureTask<Integer> task1 = new FutureTask<>(new Caller(1, 2));
        new Thread(task1).start();
        try {
            Integer result = task1.get();
            System.out.println("result: " + result);
        } catch (Exception e) {

        }
    }
}
