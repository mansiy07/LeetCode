class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxD=0,ans=0;
        for(int[] d:dimensions){
            int diagonal=d[0]*d[0]+d[1]*d[1];
            if(diagonal>maxD){
                maxD=diagonal;
                ans=d[0]*d[1];
            }else if(diagonal==maxD){
                ans=Math.max(ans,d[0]*d[1]);
            }
        }
        return ans;
    }
}