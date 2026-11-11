// class Solution {
//     public int fxn(int slices[],int i,int end,int k,int dp[][]){
//         if(k==0) return 0;
//         if(i>end || end-i+1<2*k-1) return Integer.MIN_VALUE/2;
//         if(dp[i][k]!=-1) return dp[i][k];
//         int take=slices[i]+fxn(slices,i+2,end,k-1,dp);
//         int notTake=fxn(slices,i+1,end,k,dp);
//         return dp[i][k]=Math.max(take,notTake);
//     }
//     public int maxSizeSlices(int[] slices) {
//         int n = slices.length;
//         int k = n / 3;
//         int dp1[][]=new int[n][k+1];
//         int dp2[][]=new int[n][k+1];
//         for(int i=0; i<n;i++){
//             for(int j=0;j<=k;j++){
//                 dp1[i][j]=-1;
//                 dp2[i][j] =-1;
//             }
//         }
//         int a=fxn(slices,0,n-2,k,dp1);
//         int b=fxn(slices,1,n-1,k,dp2);
//         return Math.max(a,b);
//     }
// }


// Tabulation


class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int k=n/3;
        int dp1[][]=new int[n+2][k+1];
        int dp2[][]=new int[n+2][k+1];
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<=k;j++){
                if(n-1-i<2*j-1){
                    dp1[i][j]=Integer.MIN_VALUE/2;
                } else {
                    int take=slices[i]+dp1[i+2][j-1];
                    int notTake=dp1[i+1][j];
                    dp1[i][j]=Math.max(take,notTake);
                }
            }
        }
        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=k;j++){
                if(n-i<2*j-1){
                    dp2[i][j]=Integer.MIN_VALUE/2;
                } else {
                    int take=slices[i]+dp2[i+2][j-1];
                    int notTake=dp2[i+1][j];
                    dp2[i][j]=Math.max(take,notTake);
                }
            }
        }
        return Math.max(dp1[0][k],dp2[1][k]);
    }
}
