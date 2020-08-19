// https://leetcode-cn.com/problems/number-of-1-bits/
public class L0191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rt = 0;
        while (n != 0) {
            n = n & (n - 1);
            rt++;
        }

        return rt;
    }
}
