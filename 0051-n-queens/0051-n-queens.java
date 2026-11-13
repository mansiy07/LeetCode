class Solution {
    List<List<String>> ans=new ArrayList<>();
    public void solve(int row,int n,char[][] board,boolean[] col,boolean[] diag1,boolean[] diag2){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int j=0;j<n;j++){
            int d1=row-j+n-1;
            int d2=row+j;
            if(col[j] || diag1[d1] || diag2[d2]) continue;
            board[row][j]='Q';
            col[j]=diag1[d1]=diag2[d2]=true;
            solve(row+1,n,board,col,diag1,diag2);
            board[row][j]='.';
            col[j]=diag1[d1]=diag2[d2]=false;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board) Arrays.fill(row,'.');
        boolean[] col=new boolean[n];
        boolean[] diag1=new boolean[2*n-1];
        boolean[] diag2=new boolean[2*n-1];
        solve(0,n,board,col,diag1,diag2);
        return ans;
    }
}