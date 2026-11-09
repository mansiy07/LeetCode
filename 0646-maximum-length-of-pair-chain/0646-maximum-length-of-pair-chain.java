// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs,(a,b) -> a[0]-b[0]);
//         int n=pairs.length;
//         int dp[][]=new int[n][n+1];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(0,-1,pairs,dp);
//     }
//     public int solve(int i,int prev,int[][] pairs,int dp[][]){
//         if(i==pairs.length) return 0;
//         if(dp[i][prev+1]!=-1) return dp[i][prev+1];
//         int skip=solve(i+1,prev,pairs,dp);
//         int take=0;
//         if(prev==-1 || pairs[prev][1]<pairs[i][0]){
//             take=1+solve(i+1,i,pairs,dp);
//         }
//         return dp[i][prev+1] = Math.max(take,skip);
//     }
// }


// Tabulation 

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int n=pairs.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int skip=dp[i+1][prev+1];
                int take=0;
                if(prev==-1 || pairs[prev][1] <pairs[i][0]){
                    take=1+dp[i+1][i+1];
                }
                dp[i][prev+1]=Math.max(take,skip);
            }
        }
        return dp[0][0];
    }
}