package com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵II
 *
 * @author ZhangFuQi
 * @date 2021/8/1 23:09
 */
public class S54SpiralMatrix1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(100);
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

        int offset = 1;
        int startX = 0;
        int startY = 0;

        int loop = Math.max(matrix.length, matrix[0].length) >> 1;

        while (loop > 0 && startX < n && startY < m) {
            int i = startX;
            int j = startY;

            for (; j < startY + m - offset; j++) {
                if (!visited[startX][j]) {
                    ans.add(matrix[startX][j]);
                    visited[startX][j] = true;
                }
            }
            for (; i < startX + n - offset; i++) {
                if (!visited[i][j]) {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                }
            }
            for (; j > startY; j--) {
                if (!visited[i][j]) {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                }
            }
            for (; i > startX; i--) {
                if (!visited[i][j]) {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                }
            }
            startX++;
            startY++;
            offset += 2;

            loop--;
        }
        if (m == n && n % 2 != 0) {
            ans.add(matrix[n / 2][n / 2]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new S54SpiralMatrix1().spiralOrder(new int[][]{new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}}));
    }
}
