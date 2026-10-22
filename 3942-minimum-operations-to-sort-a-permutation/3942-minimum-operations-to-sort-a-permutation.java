class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        int ans = Integer.MAX_VALUE;
        if (check(nums, n, zero, 1)) {
            ans = Math.min(ans, Math.min(zero, n - zero + 2));
        }
        if (check(nums, n, zero, -1)) {
            ans = Math.min(ans, Math.min(zero + 2, n - zero));
        }   
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private boolean check(int[] nums, int n, int zero, int step) {
        for (int i = 1; i < n; i++) {
            int prev = (zero + (i - 1) * step) % n;
            int curr = (zero + i * step) % n;
            if (prev < 0) prev += n;
            if (curr < 0) curr += n;
            if (nums[prev] > nums[curr]) {
                return false;
            }
        }
        return true;
    }
}