package com.sean.base.maze;

import java.util.Scanner;

/**
 * @author sean
 * 假设有n*n的迷宫方阵，假设n=3入口为(1,1) 出口为（3,3）
 * 1.求不重复的路径有多少条
 * 2.求路径
 */

public class MazePath {
    private int level;
    private int paths = 0;

    public MazePath(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPaths() {
        return paths;
    }

    private boolean move(int x, int y) {
        if (x == level && y == level) {
            System.out.println("path :  (" + x + ", " + y + ")");
            paths += 1;
            return true;
        }

        if (x > level || y > level) {
            return false;
        }

        boolean right = move(x + 1, y);
        boolean down = move(x, y + 1);

        if (right) {
            System.out.println("path : (" + x + ", " + y + ") -> (" + (x + 1) + ", " + y + ")");
        }

        if (down) {
            System.out.println("path: (" + x + ", " + y + ") -> (" + (x) + ", " + (y + 1) + ")");
        }

        return right || down;

    }

    public static void main(String[] args) {
        int level = new Scanner(System.in).nextInt();
        MazePath mazePath = new MazePath(level);
        mazePath.move(1, 1);
        System.out.println("n paths:" + mazePath.getPaths());
    }
}
