//// Tabulation
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n=text1.length();
//         int m=text2.length();
//         int dp[][]=new int[n+1][m+1];
//         for(int i=1;i<=n;i++) {
//             for(int j=1;j<=m;j++){
//                 if(text1.charAt(i-1)==text2.charAt(j-1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }else{
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }


//// Memoization
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] =-1;
            }
        }
        return solve(text1,text2,n,m);
    }
    int solve(String text1, String text2, int i, int j){
        if (i==0 || j==0){
            return 0;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return dp[i][j]=1+solve(text1,text2,i-1,j-1);
        }
        return dp[i][j]=Math.max(
            solve(text1,text2,i-1,j),
            solve(text1,text2,i,j-1)
        );
    }
}