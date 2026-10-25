class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0 && dfs(grid, i, j))
                    ans++;

        return ans;
    }

    boolean dfs(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length)
            return false;
        if (g[i][j] == 1) return true;

        g[i][j] = 1;

        return dfs(g, i+1, j) & dfs(g, i-1, j)
             & dfs(g, i, j+1) & dfs(g, i, j-1);
    }
}