class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        //LCS DP table
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //Construct SCS using LCS table
        StringBuilder result=new StringBuilder();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            //take lcs from both strings(comman characters from both strings)
            if (str1.charAt(i-1)==str2.charAt(j-1)){
                result.append(str1.charAt(i-1));
                i--;
                j--;
            }
            //common character from str1
            else if(dp[i-1][j]>dp[i][j-1]){
                result.append(str1.charAt(i-1));
                i--;
            }
            //comman character from str2
            else{
                result.append(str2.charAt(j-1));
                j--;
            }
        }
        //uncomman characters of str1
        while (i > 0){
            result.append(str1.charAt(i-1));
            i--;
        }
        //uncommon characters of str2
        while(j>0){
            result.append(str2.charAt(j-1));
            j--;
        }
        return result.reverse().toString();
    }
}