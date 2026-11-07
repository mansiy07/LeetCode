// class Solution {
//     public int fxn(int i,int dp[]){
//         if(i==0) return 0;
//         if(dp[i]!=-1) return dp[i];
//         int ans=fxn(i/2,dp)+(i%2);
//         return dp[i] = ans;
//     }
//     public int[] countBits(int n){
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         int ans[]=new int[n+1];
//         for(int i=0;i<=n;i++){
//             ans[i]=fxn(i,dp);
//         }
//         return ans;
//     }
// }


// Tabulation


class Solution {
    public int[] countBits(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i/2]+(i%2);
        }
        return dp;
    }
}
