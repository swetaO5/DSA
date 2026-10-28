class Solution {
    public double myPow(double x, int n) {
        long exponent = n;
        boolean negative = exponent < 0;
        if (negative) {
            exponent = -exponent;
        }
        double result = 1.0;
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                result *= x;
            }
            x *= x;
            exponent >>= 1;
        }
        return negative ? 1.0 / result : result;
    }
}