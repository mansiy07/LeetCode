class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int r = num % k;
            long[] next = new long[k];

            // Subarray consisting only of num
            next[r]++;

            // Extend every previous subarray
            for (int j = 0; j < k; j++) {
                next[(j * r) % k] += dp[j];
            }

            // Add all subarrays ending at current index
            for (int j = 0; j < k; j++) {
                ans[j] += next[j];
            }

            dp = next;
        }

        return ans;
    }
}