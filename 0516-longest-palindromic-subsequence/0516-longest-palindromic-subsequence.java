class Solution{
    int[][] dp;
    String s;
    public int longestPalindromeSubseq(String str){
        s=str;
        int n = s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return fxn(0,n-1);
    }
    public int fxn(int i, int j){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+fxn(i+1,j-1);
        }
        return dp[i][j]=Math.max(fxn(i+1,j),fxn(i,j-1));
    }
}