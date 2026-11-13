// class Solution {
//     int dp[][];
//     int fxn(int i,int diff,int[] nums){
//         if(i<0) return 0;
//         if(dp[i][diff+500]!=-1) return dp[i][diff+500];
//         int ans=0;
//         for(int j=i-1;j>=0;j--){
//             if(nums[i]-nums[j]==diff){
//                 ans=Math.max(ans,1+fxn(j,diff,nums));
//             }
//         }
//         return dp[i][diff+500]=ans;
//     }
//     public int longestArithSeqLength(int[] nums) {
//         int n=nums.length;
//         dp=new int[n][1001];
//         for(int[] row:dp) Arrays.fill(row,-1);
//         int ans=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<i;j++){
//                 int diff=nums[i]-nums[j];
//                 ans=Math.max(ans,2+fxn(j,diff,nums));
//             }
//         }
//         return ans;
//     }
// }


// Tabulation

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][1001];
        int ans=0;
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j]+500;
                dp[i][diff]=dp[j][diff]+1;
                ans=Math.max(ans,dp[i][diff]);
            }
        }
        return ans;
    }
}