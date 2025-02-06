
// https://leetcode-cn.com/problems/reverse-integer/
public class L0007_Reverse_Integer {
    public int reverse(int x) {
        long ans = 0;
        while(x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
            if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
                return 0;
        }
        return (int)ans;
    }
}