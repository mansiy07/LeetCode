class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x = 1 / x;
            N = -N;
        }
        return fxn(x,N);
    }
    public double fxn(double x,long n) {
        if(n==0){
            return 1;
        }
        double xnm1=fxn(x,n/2);
        if(n%2==0){
            return xnm1*xnm1;
        }
        return x*xnm1*xnm1;
    }
}