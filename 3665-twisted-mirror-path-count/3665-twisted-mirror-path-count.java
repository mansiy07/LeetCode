class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) {
                    continue;
                }

                long ways = dp[i][j];

                // Try moving right.
                int[] right = resolve(grid, i, j + 1, 0);
                if (right[0] != -1) {
                    dp[right[0]][right[1]] =
                        (dp[right[0]][right[1]] + ways) % MOD;
                }

                // Try moving down.
                int[] down = resolve(grid, i + 1, j, 1);
                if (down[0] != -1) {
                    dp[down[0]][down[1]] =
                        (dp[down[0]][down[1]] + ways) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    // direction: 0 = right, 1 = down
    private int[] resolve(int[][] grid, int r, int c, int direction) {
        int m = grid.length;
        int n = grid[0].length;

        while (r >= 0 && r < m && c >= 0 && c < n
                && grid[r][c] == 1) {

            if (direction == 0) {
                // Entered the mirror while moving right.
                r++;
                direction = 1;
            } else {
                // Entered the mirror while moving down.
                c++;
                direction = 0;
            }
        }

        if (r < 0 || r >= m || c < 0 || c >= n) {
            return new int[]{-1, -1};
        }

        return new int[]{r, c};
    }
}