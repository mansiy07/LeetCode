class Solution {
    public int findNumberOfLIS(int[] arr){
        int n=arr.length;
        int dp[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count,1);
        int maxCount=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxCount=Math.max(maxCount,dp[i]);
        }
        int finalCount=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxCount){
                finalCount+=count[i];
            }
        }
        return finalCount;
    }
}