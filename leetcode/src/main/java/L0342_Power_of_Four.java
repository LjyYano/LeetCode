
// https://leetcode-cn.com/problems/power-of-four/
public class L0342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        return ((n & (n - 1)) == 0) && ((n & 0x55555555) != 0);
    }
}