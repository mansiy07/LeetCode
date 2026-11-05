class Solution {
    public static int fxn(int i,int cost[],int dp[]){
        int n=cost.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int oneStp=fxn(i+1,cost,dp);
        int twoStp=fxn(i+2,cost,dp);
        dp[i]=cost[i]+Math.min(oneStp,twoStp);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(fxn(0,cost,dp),fxn(1,cost,dp));
    }
}