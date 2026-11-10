class Solution {
    public static int fxn(int curr,int copy,int n,int dp[][]){
        if(n==curr) return 0;
        if(curr>n) return 10000;
        if(dp[curr][copy]!=-1) return dp[curr][copy];
        int paste=1+fxn(curr+copy,copy,n,dp);
        int copyAll=10000;
        if(curr!=copy){
            copyAll=1+fxn(curr,curr,n,dp);
        }
        return dp[curr][copy]=Math.min(paste,copyAll);
    }
    public int minSteps(int n) {
        if(n==1) return 0;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return 1+fxn(1,1,n,dp);
    }
}