// class Solution {
//     int[][] dp;
//     public int change(int amount,int[] coins) {
//         dp=new int[coins.length][amount+1];
//         for(int i=0;i<coins.length;i++) Arrays.fill(dp[i],-1);
//         return fxn(0,amount,coins);
//     }
//     public int fxn(int i,int amount,int[] coins) {
//         if(amount==0) return 1;
//         if(i==coins.length) return 0;
//         if(dp[i][amount]!=-1) return dp[i][amount];
//         int take=0;
//         if(coins[i]<=amount) take=fxn(i,amount-coins[i],coins);
//         int notTake=fxn(i+1,amount,coins);
//         return dp[i][amount]=take+notTake;
//     }
// }


// Tabulation

class Solution {
    public int change(int amount,int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for(int i=n-1;i>=0;i--) {
            for(int j=1;j<=amount;j++) {
                int take=0;
                if(coins[i]<=j) take=dp[i][j-coins[i]];
                int notTake=dp[i+1][j];
                dp[i][j]=take+notTake;
            }
        }
        return dp[0][amount];
    }
}