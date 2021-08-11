package com.github;

/**
 * 岛屿数量
 *
 * @author ZhangFuQi
 * @date 2021/8/11 21:51
 */
public class S200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (grid.length == 0) {
            return 0;
        }
        int ans = 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, n, m);
                }

            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return;
        }
        //遍历过了
        if (grid[r][c] != '1') {
            return;
        }
        //定义当前遍历
        grid[r][c] = '2';
        dfs(grid, r + 1, c, n, m);
        dfs(grid, r, c + 1, n, m);
        dfs(grid, r - 1, c, n, m);
        dfs(grid, r, c - 1, n, m);
    }
}
