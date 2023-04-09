package com.sean.code.leet;

/**
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 *
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 */
public class Code2427 {
    public static class Solution {
        public int commonFactors(int a, int b) {
            int min = a >= b ? b : a;
            int count = 0;
            for (int i = 1; i <= min; i++) {
                if (a % i ==0 && b % i == 0) {
                    count ++;
                }
            }
            return count;
        }
    }
}
