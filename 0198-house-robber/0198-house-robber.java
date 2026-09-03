class Solution{
    int dp[];
    public int rob(int nums[]){
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return fxn(0,nums);
    }
    public int fxn(int i,int nums[]){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int exclude=0+fxn(i+1,nums);
        int include=nums[i]+fxn(i+2,nums);
        return dp[i]= Math.max(include,exclude);
    }
}