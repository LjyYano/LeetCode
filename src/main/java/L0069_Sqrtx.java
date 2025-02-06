
// https://leetcode-cn.com/problems/sqrtx/
public class L0069_Sqrtx {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        int L = 1, R = x;
        while(L <= R) {
            int mid = (L + R) / 2;
            int m1 = x / mid, m2 = x / (mid + 1);
            if(m1 == mid) return mid;
            if(m2 == mid + 1) return mid + 1;
            if(mid < m1 && mid + 1 > m2) return mid;
            if(mid > m1) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return 1;
    }
}