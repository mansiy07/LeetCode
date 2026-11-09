class Solution {
    public static int fxn(int i,int buy,int prices[],int fee,int dp[][]){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            int take=-prices[i]+fxn(i+1,0,prices,fee,dp);
            int skip=fxn(i+1,1,prices,fee,dp);
            profit=Math.max(take,skip);
        }else{ //buy==0
            int take=prices[i]-fee+fxn(i+1,1,prices,fee,dp);
            int skip=fxn(i+1,0,prices,fee,dp);
            profit=Math.max(take,skip);
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices,int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,1,prices,fee,dp);
    }
}