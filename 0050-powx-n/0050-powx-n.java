class Solution {
    public double myPow(double x, int n) {
        long exponent = n;
        boolean negativeExponent = exponent < 0;
        if (negativeExponent) {
            exponent = -exponent;
        }
        double result = 1.0;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= x;
            }
            x *= x;
            exponent >>= 1;
        }
        return negativeExponent ? 1.0 / result : result;
    }
}