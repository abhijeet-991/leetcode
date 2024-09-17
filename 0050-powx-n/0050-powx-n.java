public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double base = x;
        
        while (N > 0) {
            if ((N % 2) == 1) {
                result *= base;
            }
            base *= base;
            N /= 2;
        }
        
        return result;
    }
}
