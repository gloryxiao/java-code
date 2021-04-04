package com.sean.base.unit;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JavaUtilQueTest {
    @Test
    public void test () throws Exception {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        Assert.assertEquals(1, queue.peek().intValue());
        Assert.assertEquals(1, (int) queue.poll());
    }

    @Test
    public void test001() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



}
