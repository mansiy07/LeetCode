class Solution{
    static int dp[][];
    public boolean canPartition(int[] nums){
        int sum=0;
        for (int x : nums){
            sum += x;
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum / 2;
        dp=new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return fxn(nums,0,target);
    }
    public boolean fxn(int nums[],int i,int target){
        if (target==0){
            return true;
        }
        if(i==nums.length||target<0){
            return false;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }
        boolean in=fxn(nums,i+1,target-nums[i]);
        boolean ex=fxn(nums,i+1,target);
        boolean ans=in||ex;
        dp[i][target]=ans?1:0;
        return ans;
    }
}