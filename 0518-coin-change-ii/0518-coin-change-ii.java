class Solution {
    int[][] dp;
    public int change(int amount,int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i],-1);
        return fxn(0,amount,coins);
    }
    public int fxn(int i,int amount,int[] coins) {
        if(amount==0) return 1;
        if(i==coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int take=0;
        if(coins[i]<=amount) take=fxn(i,amount-coins[i],coins);
        int notTake=fxn(i+1,amount,coins);
        return dp[i][amount]=take+notTake;
    }
}
