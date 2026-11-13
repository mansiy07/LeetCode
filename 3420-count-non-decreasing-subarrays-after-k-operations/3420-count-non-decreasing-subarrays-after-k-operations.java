class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long ans=0,cost=0;
        int dp[]=new int[n];
        int head=0,tail=0,j=n-1;
        for(int i=n-1;i>=0;i--){
            while(tail>head && nums[dp[tail-1]]<nums[i]){
                int l=dp[--tail];
                int r=tail>head?dp[tail-1]:j+1;
                cost+=(long)(r-l)*(nums[i]-nums[l]);
            }
            dp[tail++]=i;
            while(cost>k){
                cost-=nums[dp[head]]-nums[j];
                if(dp[head]==j) head++;
                j--;
            }
            ans+=j-i+1;
        }
        return ans;
    }
}