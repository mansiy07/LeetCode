class Solution {
    int m, n;
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        dp = new int[m][n][m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(grid, 0, 0, 0);
    }
    private boolean dfs(char[][] grid, int r, int c, int balance) {
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }
        if (balance < 0) {
            return false;
        }
        int remaining = (m - 1 - r) + (n - 1 - c);
        if (balance > remaining) {
            return false;
        }
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }
        if (dp[r][c][balance] != -1) {
            return dp[r][c][balance] == 1;
        }
        boolean down = false;
        boolean right = false;
        if (r + 1 < m) {
            down = dfs(grid, r + 1, c, balance);
        }
        if (c + 1 < n) {
            right = dfs(grid, r, c + 1, balance);
        }
        boolean ans = down || right;
        dp[r][c][balance] = ans ? 1 : 0;
        return ans;
    }
}