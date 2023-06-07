package com.sean.code.leet.list;
//有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
//
// 下标为 i 处的奶酪被吃掉的得分为：
//
//
// 如果第一只老鼠吃掉，则得分为 reward1[i] 。
// 如果第二只老鼠吃掉，则得分为 reward2[i] 。
//
//
// 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
//
// 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
//
//
//
// 示例 1：
//
//
//输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
//输出：15
//解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
//总得分为 4 + 4 + 3 + 4 = 15 。
//15 是最高得分。
//
//
// 示例 2：
//
//
//输入：reward1 = [1,1], reward2 = [1,1], k = 2
//输出：2
//解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
//总得分为 1 + 1 = 2 。
//2 是最高得分。
//
//
//
//
// 提示：
//
//
// 1 <= n == reward1.length == reward2.length <= 105
// 1 <= reward1[i], reward2[i] <= 1000
// 0 <= k <= n
//
// Related Topics 贪心 数组 排序 堆（优先队列）
// 👍 65 👎 0

import java.util.Arrays;

public class Code2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        int n = reward1.length;
        int[] diff = new int[n];
        for (int idx = 0; idx < n; idx ++) {
            sum += reward2[idx];
            diff[idx] = reward1[idx] - reward2[idx];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i ++) {
            sum += diff[n-1-i];
        }
        return sum;
    }
}
