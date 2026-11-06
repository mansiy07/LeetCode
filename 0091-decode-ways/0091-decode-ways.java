class Solution {
    public static int fxn(int i,String s,int dp[]){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int take1digit=fxn(i+1,s,dp);
        int take2digit=0;
        if(i+1<s.length()){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26){
                take2digit=fxn(i+2,s,dp);
            }
        }
        return dp[i]=take1digit+take2digit;
    }
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return fxn(0,s,dp);
    }
}