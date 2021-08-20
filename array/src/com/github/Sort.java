package com.github;

import java.util.Arrays;

/**
 * 根据身高年龄排序,字节跳动面试题，耻辱柱
 *
 * @author ZhangFuQi
 * @date 2021/8/17 17:49
 */
public class Sort {
    public static void sort(int[][] p) {
        int n = p.length;
        int m = p[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p[j][0] < p[j + 1][0]) {
                    int[] temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                } else if (p[j][0] == p[j + 1][0]) {
                    if (p[j][1] < p[j + 1][1]) {
                        int[] temp = p[j];
                        p[j] = p[j + 1];
                        p[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{7, 3}, {7, 9}, {8, 2}, {9, 3}, {9, 10}};
        sort(p);
        System.out.println(Arrays.deepToString(p));
    }
}
