class Solution {
    public int solve(int n,int dp[]) {
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans = 0;
        for(int i=1;i<=n;i++) {
            int left = solve(i - 1, dp);
            int right = solve(n - i, dp);
            ans += left * right;
        }
        return dp[n] = ans;
    }
    public int numTrees(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}
