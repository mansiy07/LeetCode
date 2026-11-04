class Solution {
    int dp[][];
    int arr[];
    public int minCost(int n,int cuts[]) {
        int m=cuts.length;
        Arrays.sort(cuts);
        arr=new int[m+2];
        arr[0] = 0;
        arr[m+1]=n;
        for(int i=0;i<m;i++){
            arr[i+1]=cuts[i];
        }
        dp=new int[m+2][m+2];
        for(int i=0;i<m+2;i++){
            Arrays.fill(dp[i],-1);
        }
        return fxn(0,m+1);
    }
    public int fxn(int i,int j){
        if(j==i+1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int result=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost = fxn(i,k)+fxn(k,j)+arr[j]-arr[i];
            result=Math.min(result,cost);
        }
        return dp[i][j]=result;
    }
}
