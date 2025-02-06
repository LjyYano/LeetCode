
// https://leetcode-cn.com/problems/factorial-trailing-zeroes/
public class L0172_Factorial_Trailing_Zeroes {
   public int trailingZeroes(int n) {
        int rt = 0;
        for (long i = 5; i <= n; i *= 5) {
            rt += n / i;
        }
        return rt;
    }
}