import java.util.*;
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums);
        long ans = 0;
        int MOD = 1000000007;
        for (int i = left - 1; i < right; i++) {
            ans += sums.get(i);
            ans %= MOD;
        }
        return (int) ans;
    }
}