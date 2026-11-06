// class Solution {
//     public int solve(int n,int dp[]) {
//         if(n<=1) return 1;
//         if(dp[n]!=-1) return dp[n];
//         int ans=0;
//         for(int i=1;i<=n;i++) {
//             int left = solve(i - 1, dp);
//             int right = solve(n - i, dp);
//             ans += left * right;
//         }
//         return dp[n] = ans;
//     }
//     public int numTrees(int n) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n,dp);
//     }
// }


// Tabulation


class Solution {
    public int numTrees(int n) {
        if(n==0) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int nodes=2;nodes<=n;nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left=dp[root-1];
                int right=dp[nodes-root];
                dp[nodes]+=left*right;
            }
        }
        return dp[n];
    }
}
