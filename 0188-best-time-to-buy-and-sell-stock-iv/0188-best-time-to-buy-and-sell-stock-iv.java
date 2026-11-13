// class Solution {
//     int dp[][][];
//     int fxn(int i,int buy,int k,int[] prices){
//         if(i==prices.length || k==0) return 0;
//         if(dp[i][buy][k]!=-1) return dp[i][buy][k];
//         int ans;
//         if(buy==1){
//             int take=-prices[i]+fxn(i+1,0,k,prices);
//             int skip=fxn(i+1,1,k,prices);
//             ans=Math.max(take,skip);
//         }else{
//             int sell=prices[i]+fxn(i+1,1,k-1,prices);
//             int skip=fxn(i+1,0,k,prices);
//             ans=Math.max(sell,skip);
//         }
//         return dp[i][buy][k]=ans;
//     }
//     public int maxProfit(int k,int[] prices) {
//         int n=prices.length;
//         dp=new int[n][2][k+1];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<=1;j++){
//                 for(int t=0;t<=k;t++){
//                     dp[i][j][t]=-1;
//                 }
//             }
//         }
//         return fxn(0,1,k,prices);
//     }
// }


// Tabulation

class Solution {
    public int maxProfit(int k,int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int t=1;t<=k;t++){
                    if(buy==1){
                        dp[i][buy][t]=Math.max(-prices[i]+dp[i+1][0][t],dp[i+1][1][t]);
                    }else{
                        dp[i][buy][t]=Math.max(prices[i]+dp[i+1][1][t-1],dp[i+1][0][t]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}