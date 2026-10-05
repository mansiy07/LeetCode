class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,-1,nums,dp);
    }
    public int fxn(int i,int prev,int nums[], int dp[][]) {
        int n=nums.length;
        if(i>=n){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int ex=fxn(i+1,prev,nums,dp);
        int in=0;
        if(prev==-1 || nums[i]>nums[prev]){
            in = 1 + fxn(i + 1, i, nums, dp);
        }
        return dp[i][prev+1]=Math.max(ex,in);
    }
}

// // Tabulation
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[n];
//         Arrays.fill(dp,1);
//         int maxLIS=1;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[j]<nums[i]){
//                     dp[i]=Math.max(dp[i],dp[j]+1);
//                     maxLIS=Math.max(maxLIS,dp[i]);
//                 }
//             }
//         } 
//         return maxLIS;      
//     }
// }