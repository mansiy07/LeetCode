class Solution {
    public double myPow(double x, int n) {
        long longN = n;
        if (longN < 0) {
            longN = -longN;
        }
        double result = 1.0;
        double currentProduct = x;
        while (longN > 0) {
            if ((longN & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            longN >>= 1;
        }
        return n < 0 ? 1.0 / result : result;
    }
}