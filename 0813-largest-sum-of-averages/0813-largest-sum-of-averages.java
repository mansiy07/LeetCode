// class Solution {
//     public double fxn(int i,int k,int[] nums,double[][] dp) {
//         int n=nums.length;
//         if(k==1){
//             double sum=0;
//             for(int j=i;j<n;j++) sum+=nums[j];
//             return sum/(n-i);
//         }
//         if(dp[i][k]!=-1) return dp[i][k];
//         double sum=0,ans=0;
//         for(int j=i;j<=n-k;j++){
//             sum+=nums[j];
//             double avg=sum/(j-i+1);
//             ans=Math.max(ans,avg+fxn(j+1,k-1,nums,dp));
//         }
//         return dp[i][k]=ans;
//     }
//     public double largestSumOfAverages(int[] nums,int k) {
//         int n=nums.length;
//         double[][] dp=new double[n][k+1];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return fxn(0,k,nums,dp);
//     }
// }


// Tabulation

class Solution {
    public double largestSumOfAverages(int[] nums,int k) {
        int n=nums.length;
        double[][] dp=new double[n+1][k+1];
        for(int i=n-1;i>=0;i--){
            double sum=0;
            for(int j=i;j<n;j++) sum+=nums[j];
            dp[i][1]=sum/(n-i);
        }
        for(int partitions=2;partitions<=k;partitions++){
            for(int i=n-partitions;i>=0;i--){
                double sum=0;
                for(int j=i;j<=n-partitions;j++){
                    sum+=nums[j];
                    double avg=sum/(j-i+1);
                    dp[i][partitions]=Math.max(dp[i][partitions],avg+dp[j+1][partitions-1]);
                }
            }
        }
        return dp[0][k];
    }
}

