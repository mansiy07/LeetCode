class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=Math.min(n,i+3);j++){
                int jump=j-i;
                int curr=dp[i]+costs[j-1]+jump*jump;
                dp[j]=Math.min(dp[j],curr);
            }
        }
        return dp[n];
    }
}