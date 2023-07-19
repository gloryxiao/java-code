package com.sean.base.unit.leetcn;

import com.sean.code.leet.offer.Offer12;
import org.junit.Test;

public class Code79Test {
    @Test
    public void test1() {
        Offer12 offer12 = new Offer12();
        char[][] board = new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        String word = "aaaaaaaaaaaaa";
        boolean result = offer12.exist(board, word);
        System.out.println("result: " + result);
    }
}
