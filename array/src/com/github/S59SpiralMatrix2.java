package com.github;

/**
 * 螺旋矩阵II
 *
 * @author ZhangFuQi
 * @date 2021/8/1 23:09
 */
public class S59SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 1;
        int offset = 1;
        int startX = 0;
        int startY = 0;
        int loop = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;
            //从左到右
            for (; j < startY + n - offset; j++) {
                matrix[startX][j] = left++;
            }
            //从上到下
            for (; i < startX + n - offset; i++) {
                matrix[i][j] = left++;
            }
            //从右到左
            for (; j > startY; j--) {
                matrix[i][j] = left++;
            }
            for (; i > startX; i--) {
                matrix[i][j] = left++;
            }
            startX++;
            startY++;
            offset += 2;
            loop--;
        }
        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = left;
        }

        return matrix;
    }
}
