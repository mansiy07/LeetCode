class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long ans=0,cost=0;
        int[] dq=new int[n];
        int head=0,tail=0,j=n-1;
        for(int i=n-1;i>=0;i--){
            while(tail>head && nums[dq[tail-1]]<nums[i]){
                int l=dq[--tail];
                int r=tail>head?dq[tail-1]:j+1;
                cost+=(long)(r-l)*(nums[i]-nums[l]);
            }
            dq[tail++]=i;
            while(cost>k){
                cost-=nums[dq[head]]-nums[j];
                if(dq[head]==j) head++;
                j--;
            }
            ans+=j-i+1;
        }
        return ans;
    }
}