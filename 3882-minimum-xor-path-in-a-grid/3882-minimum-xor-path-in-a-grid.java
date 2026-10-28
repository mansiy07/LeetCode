import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer>[][] dp = new HashSet[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = new HashSet<>();

        dp[0][0].add(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                Set<Integer> curr = dp[i][j];

                if (i > 0)
                    for (int x : dp[i - 1][j])
                        curr.add(x ^ grid[i][j]);

                if (j > 0)
                    for (int x : dp[i][j - 1])
                        curr.add(x ^ grid[i][j]);
            }
        }

        return Collections.min(dp[m - 1][n - 1]);
    }
}