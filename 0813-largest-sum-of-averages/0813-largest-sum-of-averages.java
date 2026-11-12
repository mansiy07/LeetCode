class Solution {
    public double fxn(int i,int k,int[] nums,double[][] dp) {
        int n=nums.length;
        if(k==1){
            double sum=0;
            for(int j=i;j<n;j++) sum+=nums[j];
            return sum/(n-i);
        }
        if(dp[i][k]!=-1) return dp[i][k];
        double sum=0,ans=0;
        for(int j=i;j<=n-k;j++){
            sum+=nums[j];
            double avg=sum/(j-i+1);
            ans=Math.max(ans,avg+fxn(j+1,k-1,nums,dp));
        }
        return dp[i][k]=ans;
    }
    public double largestSumOfAverages(int[] nums,int k) {
        int n=nums.length;
        double[][] dp=new double[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,k,nums,dp);
    }
}



