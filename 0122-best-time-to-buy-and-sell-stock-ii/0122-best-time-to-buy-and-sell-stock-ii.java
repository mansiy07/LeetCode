class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,1,prices,dp);
    }
    int fxn(int i,int buy,int[] prices,int[][] dp){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit;
        if(buy==1){
            int take=-prices[i]+fxn(i+1,0,prices,dp);
            int skip=fxn(i+1,1,prices,dp);
            profit=Math.max(take,skip);
        }else{
            int sell=prices[i]+fxn(i+1,1,prices,dp);
            int skip=fxn(i+1,0,prices,dp);
            profit=Math.max(sell,skip);
        }
        return dp[i][buy]=profit;
    }
}
