import java.util.*;

class Solution{
    int dp[];
    public int rob(int nums[]){
        int n= nums.length;
        if(n==1){
            return nums[0];
        }
        int case1 = solve(0, n - 2, nums);
        int case2 = solve(1, n - 1, nums);
        return Math.max(case1,case2);
    }
    public int solve(int start, int end, int[] nums){
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return fxn(start,end,nums);
    }
    public int fxn(int i,int end,int nums[]){
        if(i>end){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int exclude=fxn(i+1,end,nums);
        int include=nums[i]+fxn(i+2,end,nums);
        dp[i]=Math.max(include,exclude);
        return dp[i];
    }
}