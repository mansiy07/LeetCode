class Solution {
    public static int fxn(int n,int dp[]){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int takePerSq=1+fxn(n-i*i,dp);
            ans=Math.min(ans,takePerSq);
        }
        return dp[n]=ans;
    }
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return fxn(n,dp);
    }
}