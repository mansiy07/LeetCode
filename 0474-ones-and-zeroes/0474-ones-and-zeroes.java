// class Solution{
//     public int fxn(int i,String strs[],int m,int n,int dp[][][]){
//         if(i==strs.length)return 0;
//         if(dp[i][m][n]!=-1)return dp[i][m][n];
//         int zero=0,one=0;
//         for(int j=0;j<strs[i].length();j++){
//             if(strs[i].charAt(j)=='0')zero++;
//             else one++;
//         }
//         int notPick=fxn(i+1,strs,m,n,dp);
//         int pick=0;
//         if(zero<=m&&one<=n){
//             pick=1+fxn(i+1,strs,m-zero,n-one,dp);
//         }
//         return dp[i][m][n]=Math.max(pick,notPick);
//     }
//     public int findMaxForm(String[] strs,int m,int n){
//         int dp[][][]=new int[strs.length][m+1][n+1];
//         for(int i=0;i<strs.length;i++){
//             for(int j=0;j<=m;j++){
//                 for(int k=0;k<=n;k++){
//                     dp[i][j][k]=-1;
//                 }
//             }
//         }
//         return fxn(0,strs,m,n,dp);
//     }
// }


// Tabulation

class Solution{
    public int findMaxForm(String[] strs,int m,int n){
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<strs.length;i++){
            int zero=0,one=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0')zero++;
                else one++;
            }
            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                    dp[j][k]=Math.max(dp[j][k],1+dp[j-zero][k-one]);
                }
            }
        }
        return dp[m][n];
    }
}