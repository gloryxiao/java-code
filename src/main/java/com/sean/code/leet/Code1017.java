package com.sean.code.leet;

/**
 * 你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 *
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 */
public class Code1017 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        String list = "0";
        if (n % 2 == 1) {
            n = n - 1;
            list =  "1";
        }
        int base = -2;
        while (n != 1 && n != 0) {
            n = n / base;
            if (n == 0) {
                list = "1" + list;
            } else {
                if (n % 2 == 0) {
                    list = "0" + list;
                } else {
                    list = "1" + list;
                    n = n - 1;
                }
            }
        }
        return list;
    }
}
