class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Prefix Sum
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // If Alice takes all stones
        int best = stones[n - 1];

        // DP from right to left
        for (int i = n - 2; i > 0; i--) {
            best = Math.max(best, stones[i] - best);
        }
        return best;
    }
}