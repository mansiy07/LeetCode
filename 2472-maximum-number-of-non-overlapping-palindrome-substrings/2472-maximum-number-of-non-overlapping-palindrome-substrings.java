class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // dp[i] = maximum palindromes using first i characters
        int[] dp = new int[n + 1];

        // isPal[i][j] = whether s[i...j] is a palindrome
        boolean[][] isPal = new boolean[n][n];

        // Build palindrome table
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) &&
                    (len <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        // DP
        for (int i = 1; i <= n; i++) {
            // Don't take a palindrome ending at i-1
            dp[i] = dp[i - 1];

            // Try every palindrome ending at i-1
            for (int j = 0; j <= i - k; j++) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}