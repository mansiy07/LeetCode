class Solution {
    public int climbStairs(int n) {
        int step1 = 1;
        int step2 = 2;
        if(n<=2){
            return n;
        }
        for(int i=3;i<=n;i++){
            int step3 = step1+step2;
            step1=step2;
            step2=step3;
        }
        return step2;
    }
}