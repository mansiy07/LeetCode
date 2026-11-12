// class Solution {
//     int mod=1000000007;
//     public long fxn(int prev,int rem,long[][] dp) {
//         if(rem==1) return 1;
//         if(dp[rem][prev]!=-1) return dp[rem][prev];
//         long ans=0;
//         if(prev==0){
//             ans=fxn(1,rem-1,dp);
//         }else if(prev==1){
//             ans=(fxn(0,rem-1,dp)+fxn(2,rem-1,dp))%mod;
//         }else if(prev==2){
//             ans=(fxn(0,rem-1,dp)+fxn(1,rem-1,dp)+fxn(3,rem-1,dp)+fxn(4,rem-1,dp))%mod;
//         }else if(prev==3){
//             ans=(fxn(2,rem-1,dp)+fxn(4,rem-1,dp))%mod;
//         }else{
//             ans=fxn(0,rem-1,dp);
//         }
//         return dp[rem][prev]=ans;
//     }
//     public int countVowelPermutation(int n) {
//         long dp[][]=new long[n+1][5];
//         for(long[] row:dp) Arrays.fill(row,-1);
//         long ans=0;
//         for(int i=0;i<5;i++){
//             ans=(ans+fxn(i,n,dp))%mod;
//         }
//         return (int)ans;
//     }
// }


// Tabulation

class Solution {
    public int countVowelPermutation(int n) {
        int mod=1000000007;
        long dp[][]=new long[n+1][5];
        for(int j=0;j<5;j++) dp[1][j]=1;
        for(int i=2;i<=n;i++){
            dp[i][0]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%mod;
            dp[i][3]=dp[i-1][2];
            dp[i][4]=(dp[i-1][2]+dp[i-1][3])%mod;
        }
        long ans=0;
        for(int j=0;j<5;j++){
            ans=(ans+dp[n][j])%mod;
        }
        return (int)ans;
    }
}

