class Solution {
    int dp[][][];

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        dp = new int[n][n + 1][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(nums, 0, -1, 2);
    }

    public int solve(int nums[], int i, int prev, int flag) {

        if (i == nums.length) return 0;

        if (dp[i][prev + 1][flag] != -1) {
            return dp[i][prev + 1][flag];
        }

        // Not Take
        int notTake = solve(nums, i + 1, prev, flag);

        // Take
        int take = 0;

        if (prev == -1) {
            take = 1 + solve(nums, i + 1, i, 2);
        }

        else if (nums[i] > nums[prev] && flag != 0) {
            take = 1 + solve(nums, i + 1, i, 0);
        }

        else if (nums[i] < nums[prev] && flag != 1) {
            take = 1 + solve(nums, i + 1, i, 1);
        }

        return dp[i][prev + 1][flag] =
                Math.max(take, notTake);
    }
}