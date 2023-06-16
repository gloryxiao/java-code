package com.sean.code.leet.offer;
/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Offer12 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfsCheck(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsCheck(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return !visited[i][j];
        }
        visited[i][j] = true;
        int row = board.length;
        int col = board[0].length;
        int[][] directs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] direct: directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];
            if (newI < 0 || newJ < 0 || newI > row - 1 || newJ > col - 1 || visited[newI][newJ]) {
                continue;
            }
            boolean result = dfsCheck(board, newI, newJ, word, k + 1, visited);
            if (result) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
