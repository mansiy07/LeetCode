// class Solution {
//     public int fxn(int i,int buy,int prices[],int dp[][]){
//         int n=prices.length;
//         if(i>=n) return 0;
//         if(dp[i][buy]!=-1){
//             return dp[i][buy];
//         }
//         int profit=0;
//         if(buy==1){
//             int take=-prices[i]+fxn(i+1,0,prices,dp);
//             int skip=fxn(i+1,1,prices,dp);
//             profit=Math.max(take,skip);
//         }else{
//             int sell=prices[i]+fxn(i+2,1,prices,dp);
//             int skip=fxn(i+1,0,prices,dp);
//             profit=Math.max(sell,skip);
//         }
//         return dp[i][buy]=profit;
//     }
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int dp[][]=new int[n][2];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i], -1);
//         }
//         return fxn(0,1,prices,dp);
//     }
// }


// Tabulation

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+2][2];
        for(int i=n-1;i>=0;i--){
            int buy=Math.max(
                -prices[i]+dp[i+1][0],
                dp[i+1][1]
            );
            int sell=Math.max(
                prices[i]+dp[i+2][1],
                dp[i+1][0]
            );
            dp[i][1]=buy;
            dp[i][0]=sell;
        }
        return dp[0][1];
    }
}

