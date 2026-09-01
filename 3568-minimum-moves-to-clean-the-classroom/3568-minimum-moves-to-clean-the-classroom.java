class Solution {
    static class Node {
        int r,c,mask,e,d;
        Node(int r,int c,int mask,int e,int d){
            this.r=r; this.c=c; this.mask=mask; this.e=e; this.d=d;
        }
    }
    public int minMoves(String[] a, int E) {
        int m=a.length,n=a[0].length(),sr=0,sc=0,k=0;
        int[][] id=new int[m][n];
        for(int[] x:id) Arrays.fill(x,-1);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                char ch=a[i].charAt(j);
                if(ch=='S'){sr=i;sc=j;}
                else if(ch=='L') id[i][j]=k++;
            }
        int full=(1<<k)-1;
        int[][] best=new int[m*n][1<<k];
        for(int[] x:best) Arrays.fill(x,-1);
        Queue<Node> q=new ArrayDeque<>();
        q.offer(new Node(sr,sc,0,E,0));
        best[sr*n+sc][0]=E;
        int[] dr={1,-1,0,0},dc={0,0,1,-1};
        while(!q.isEmpty()){
            Node x=q.poll();
            if(x.mask==full) return x.d;
            if(x.e==0) continue;
            for(int z=0;z<4;z++){
                int r=x.r+dr[z],c=x.c+dc[z];
                if(r<0||r>=m||c<0||c>=n||a[r].charAt(c)=='X') continue;
                int e=x.e-1;
                char ch=a[r].charAt(c);
                if(ch=='R') e=E;
                int mask=x.mask;
                if(ch=='L') mask|=1<<id[r][c];
                int pos=r*n+c;
                if(best[pos][mask]>=e) continue;
                best[pos][mask]=e;
                q.offer(new Node(r,c,mask,e,x.d+1));
            }
        }
        return -1;
    }
}