class Solution {
    int n;
    int m;
    int dp[][];
    public int calculateMinimumHP(int dungeon[][]){
        n=dungeon.length;
        m=dungeon[0].length;
        dp=new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return fxn(dungeon,0,0);
    }
    public int fxn(int matrix[][],int i,int j){
        if(i>=n || j>=m)
            return 100000000;
        if(i==n-1 && j==m-1){
            return matrix[i][j]>0?1:-matrix[i][j]+1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int r=fxn(matrix, i, j + 1);
        int d=fxn(matrix,i+1,j);
        int res=Math.min(r,d)-matrix[i][j];
        dp[i][j]=res>0?res:1;
        return dp[i][j];
    }
}