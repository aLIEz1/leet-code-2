package com.github;

/**
 * 岛屿周长
 *
 * @author ZhangFuQi
 * @date 2021/8/11 23:23
 */
public class S463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int perimeter = 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, n, m);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j, int n, int m) {
        //对应遇到边界的情况
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 1;
        }
        //对应遇到海的情况
        if (grid[i][j] == 0) {
            return 1;
        }
        //遍历过了
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;

        //当前的不算，不需要+1
        return dfs(grid, i + 1, j, n, m) +
                dfs(grid, i - 1, j, n, m) +
                dfs(grid, i, j + 1, n, m) +
                dfs(grid, i, j - 1, n, m);
    }


}
