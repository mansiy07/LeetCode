// class Solution {
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int[][][] dp=new int[n][2][3];
//         for(int[][] a:dp){
//             for(int[] b:a){
//                 Arrays.fill(b,-1);
//             }
//         }
//         return fxn(0,1,2,prices,dp);
//     }
//     int fxn(int i,int buy,int cap,int[] prices,int[][][] dp){
//         if(i==prices.length || cap==0){
//             return 0;
//         }
//         if(dp[i][buy][cap]!=-1){
//             return dp[i][buy][cap];
//         }
//         int profit;
//         if(buy==1){
//             int take=-prices[i]+fxn(i+1,0,cap,prices,dp);
//             int skip=fxn(i+1,1,cap,prices,dp);
//             profit=Math.max(take,skip);
//         }else{
//             int sell=prices[i]+fxn(i+1,1,cap-1,prices,dp);
//             int skip=fxn(i+1,0,cap,prices,dp);
//             profit=Math.max(sell,skip);
//         }
//         return dp[i][buy][cap]=profit;
//     }
// }


// Tabulation


class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    int profit;
                    if(buy==1){
                        int take=-prices[i]+dp[i+1][0][cap];
                        int skip=dp[i+1][1][cap];
                        profit=Math.max(take,skip);
                    }else{
                        int sell=prices[i]+dp[i+1][1][cap-1];
                        int skip=dp[i+1][0][cap];
                        profit=Math.max(sell,skip);
                    }
                    dp[i][buy][cap]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
}
