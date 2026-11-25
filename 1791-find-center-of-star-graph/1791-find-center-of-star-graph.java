class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int degree[]=new int[n+1];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            degree[u]++;
            degree[v]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==n-1){
                return i;  
            }
        }
        return -1;
    }
}
