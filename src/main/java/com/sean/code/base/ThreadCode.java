package com.sean.code.base;

import sun.net.www.http.HttpClient;

import java.net.URL;

/**
 * @author sean
 */
public class ThreadCode {

    public static class NumPrinter implements Runnable {
        private final Object monitor = new Object();
        private int count = 0;

        @Override
        public void run() {
            synchronized (monitor) {
                while (count < 99) {
                    monitor.notifyAll();
                    count ++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        NumPrinter printer = new NumPrinter();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {

                    URL url = new URL("https://www.ssss.com");
                    url.getContent();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t3.start();
        while (true) {
            System.out.println(t3.getState());
        }

//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
