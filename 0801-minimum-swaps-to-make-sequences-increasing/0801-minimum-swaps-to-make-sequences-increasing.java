class Solution {
    public int fxn(int i,int prevSwap,int[] nums1,int[] nums2,int[][] dp){
        if(i==nums1.length) return 0;
        if(dp[i][prevSwap]!=-1) return dp[i][prevSwap];
        int prev1=0,prev2=0;
        if(i>0){
            prev1=prevSwap==1?nums2[i-1]:nums1[i-1];
            prev2=prevSwap==1?nums1[i-1]:nums2[i-1];
        }
        int ans=Integer.MAX_VALUE;
        if(i==0 || (nums1[i]>prev1 && nums2[i]>prev2)){
            ans=fxn(i+1,0,nums1,nums2,dp);
        }
        if(i==0 || (nums2[i]>prev1 && nums1[i]>prev2)){
            ans=Math.min(ans,1+fxn(i+1,1,nums1,nums2,dp));
        }
        return dp[i][prevSwap]=ans;
    }
    public int minSwap(int[] nums1,int[] nums2) {
        int n=nums1.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,0,nums1,nums2,dp);
    }
}

