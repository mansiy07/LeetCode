// class Solution {
//     public boolean fxn(int n,int dp[]){
//         if(n == 1) return false;
//         if(dp[n]!=-1){
//             return dp[n]==1;
//         }
//         for(int x=1;x<n;x++){
//             if(n%x==0){
//                 if(!fxn(n-x,dp)){
//                     dp[n]=1;
//                     return true;
//                 }
//             }
//         }
//         dp[n]=0;
//         return false;
//     }
//     public boolean divisorGame(int n) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return fxn(n,dp);
//     }
// }


// Tabulation

class Solution {
    public boolean divisorGame(int n) {
        boolean dp[]=new boolean[n +1];
        dp[1]=false;
        for(int i=2;i<=n;i++){
            for(int x=1;x<i;x++){
                if(i%x==0){
                    if(dp[i-x]==false){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}