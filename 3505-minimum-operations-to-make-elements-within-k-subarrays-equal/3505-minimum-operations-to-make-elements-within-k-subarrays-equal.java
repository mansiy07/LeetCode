class Solution {
    static class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        long sumLeft = 0;
        long sumRight = 0;
        int sizeLeft = 0;
        int sizeRight = 0;
        void add(int num) {
            if (left.isEmpty() || num <= left.lastKey()) {
                left.put(num, left.getOrDefault(num, 0) + 1);
                sumLeft += num;
                sizeLeft++;
            } else {
                right.put(num, right.getOrDefault(num, 0) + 1);
                sumRight += num;
                sizeRight++;
            }
            balance();
        }
        void remove(int num) {
            if (left.containsKey(num)) {
                removeFrom(left, num);
                sumLeft -= num;
                sizeLeft--;
            } else {
                removeFrom(right, num);
                sumRight -= num;
                sizeRight--;
            }
            balance();
        }
        void removeFrom(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) map.remove(num);
            else map.put(num, count - 1);
        }
        void balance() {
            while (sizeLeft > sizeRight + 1) {
                int num = left.lastKey();
                removeFrom(left, num);
                sumLeft -= num;
                sizeLeft--;
                right.put(num, right.getOrDefault(num, 0) + 1);
                sumRight += num;
                sizeRight++;
            }
            while (sizeLeft < sizeRight) {
                int num = right.firstKey();
                removeFrom(right, num);
                sumRight -= num;
                sizeRight--;
                left.put(num, left.getOrDefault(num, 0) + 1);
                sumLeft += num;
                sizeLeft++;
            }
        }
        long getCost() {
            int median = left.lastKey();
            return (long) median * sizeLeft - sumLeft
                 + sumRight - (long) median * sizeRight;
        }
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        MedianWindow window = new MedianWindow();
        for (int i = 0; i < n; i++) {
            window.add(nums[i]);
            if (i >= x) {
                window.remove(nums[i - x]);
            }
            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != INF) {
                    long take = dp[j - 1][i - x]
                              + cost[i - x];
                    dp[j][i] = Math.min(dp[j][i], take);
                }
            }
        }
        return dp[k][n];
    }
}
