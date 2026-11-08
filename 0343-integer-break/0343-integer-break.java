// class Solution {
//     public static int fxn(int n,int dp[]){
//         if(n==1) return 1;
//         if(dp[n]!=-1) return dp[n];
//         int result=0;
//         for(int i=1;i<n;i++){
//             int product=i*Math.max(n-i,fxn(n-i,dp));
//             result=Math.max(result,product);
//         }
//         return dp[n]=result;
//     }
//     public int integerBreak(int n) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return fxn(n,dp);
//     }
// }


// Tabulation
class Solution {
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int j=2;j<=n;j++){
            int result=0;
            for(int i=1;i<j;i++){
                int product=i*Math.max(j-i,dp[j-i]);
                result=Math.max(result,product);
            }
            dp[j]=result;
        }
        return dp[n];
    }
}