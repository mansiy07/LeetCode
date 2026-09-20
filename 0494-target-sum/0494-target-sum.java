class Solution {
    int[][] dp;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums)
            sum += x;
        if (Math.abs(target) > sum)
            return 0;
        offset = sum;
        dp = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++)
            java.util.Arrays.fill(dp[i], -1);
        return fxn(nums, nums.length - 1, target);
    }
    int fxn(int[] nums, int i, int target) {
        if (i < 0)
            return target == 0 ? 1 : 0;
        if (target < -offset || target > offset)
            return 0;
        int idx = target + offset;
        if (dp[i][idx] != -1)
            return dp[i][idx];
        int plus = fxn(nums, i - 1, target - nums[i]);
        int minus = fxn(nums, i - 1, target + nums[i]);
        return dp[i][idx] = plus + minus;
    }
}