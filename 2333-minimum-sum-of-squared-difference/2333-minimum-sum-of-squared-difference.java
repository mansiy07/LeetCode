import java.util.Arrays;
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long sum = 0;
        long k = (long) k1 + k2;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
        }
        if (sum <= k) return 0;
        Arrays.sort(diff);
        long left = 0;
        long right = diff[n - 1];
        while (left < right) {
            long mid = left + (right - left) / 2;
            long operations = 0;
            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }
            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        long level = left;
        long ans = 0;
        for (int d : diff) {
            if (d > level) {
                k -= d - level;
                d = (int) level;
            }
            ans += (long) d * d;
        }
        ans -= k * (2 * level - 1);
        return ans;
    }
}
