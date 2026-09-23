class Solution{
    int dp[][];
    public int minDistance(String word1,String word2){
        int n=word1.length();
        int m=word2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        int lcs=fxn(word1,word2,n,m);
        int delFromS1=n-lcs;
        int delFromS2=m-lcs;
        return delFromS1+delFromS2;
    }
    int fxn(String text1,String text2,int i,int j){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return dp[i][j] =1+fxn(text1,text2,i-1,j-1);
        }
        return dp[i][j]=Math.max(fxn(text1,text2,i-1,j),fxn(text1,text2,i,j-1));
    }
}