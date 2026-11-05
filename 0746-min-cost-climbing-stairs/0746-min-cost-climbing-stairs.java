// class Solution {
//     public static int fxn(int i,int cost[],int dp[]){
//         int n=cost.length;
//         if(i>=n) return 0;
//         if(dp[i]!=-1) return dp[i];
//         int oneStp=fxn(i+1,cost,dp);
//         int twoStp=fxn(i+2,cost,dp);
//         dp[i]=cost[i]+Math.min(oneStp,twoStp);
//         return dp[i];
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//         int dp[]=new int[n];
//         Arrays.fill(dp,-1);
//         return Math.min(fxn(0,cost,dp),fxn(1,cost,dp));
//     }
// }


// Tabulation

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+2];
        dp[n]=0;
        dp[n+1]=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}
