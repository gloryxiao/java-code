package com.sean.code.base;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * jdk 7 fork join
 */
public class ForkJoinCode {
    private static final int THRD = 10;
    public static class CalcJob extends RecursiveTask<Integer> {
        private int start;
        private int end;

        public CalcJob(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRD) {
                return IntStream.rangeClosed(start, end).sum();
            }
            int mid = (start + end) / 2;
            CalcJob leftJob = new CalcJob(start, mid);
            CalcJob rightJob = new CalcJob(mid + 1, end);
            leftJob.fork();
            rightJob.fork();
            return leftJob.join() + rightJob.join();
        }
    }

    public static void main(String[] args) {
        CalcJob calcJob = new CalcJob(1, 100);
        try {
            Future<Integer> result = new ForkJoinPool().submit(calcJob);
            int res = result.get();
            System.out.println(res);
        } catch (Exception e) {

        }
    }
}
