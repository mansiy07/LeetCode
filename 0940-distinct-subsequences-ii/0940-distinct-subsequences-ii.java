class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007L;
        int n = s.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        dp[0] = 1; 
        for (int i = 1; i <= n; i++) {
            int ch = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1]) % MOD;
            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch]] + MOD) % MOD;
            }
            last[ch] = i - 1;
        }
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}