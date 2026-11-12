class Solution {
    int mod=1000000007;
    public long fxn(int prev,int rem,long[][] dp) {
        if(rem==1) return 1;
        if(dp[rem][prev]!=-1) return dp[rem][prev];
        long ans=0;
        if(prev==0){
            ans=fxn(1,rem-1,dp);
        }else if(prev==1){
            ans=(fxn(0,rem-1,dp)+fxn(2,rem-1,dp))%mod;
        }else if(prev==2){
            ans=(fxn(0,rem-1,dp)+fxn(1,rem-1,dp)+fxn(3,rem-1,dp)+fxn(4,rem-1,dp))%mod;
        }else if(prev==3){
            ans=(fxn(2,rem-1,dp)+fxn(4,rem-1,dp))%mod;
        }else{
            ans=fxn(0,rem-1,dp);
        }
        return dp[rem][prev]=ans;
    }
    public int countVowelPermutation(int n) {
        long dp[][]=new long[n+1][5];
        for(long[] row:dp) Arrays.fill(row,-1);
        long ans=0;
        for(int i=0;i<5;i++){
            ans=(ans+fxn(i,n,dp))%mod;
        }
        return (int)ans;
    }
}




