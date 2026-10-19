class Solution {
    public double myPow(double x, int n) {
        long longN = n; // Use long to prevent overflow when negating Integer.MIN_VALUE
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
        
        // Take reciprocal at the very end to preserve precision
        return n < 0 ? 1.0 / result : result;
    }
}