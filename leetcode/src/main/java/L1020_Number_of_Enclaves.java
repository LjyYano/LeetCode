
// https://leetcode-cn.com/problems/number-of-enclaves/
class L1020_Number_of_Enclaves {
    public int maxTurbulenceSize(int[] A) {
        int res = 0;
        for (int i = 0, ans = 0; i < A.length - 1; i++, ans *= -1) {
            if (A[i] > A[i + 1]) {
                ans = ans > 0 ? (ans + 1) : 1;
            } else if (A[i] < A[i + 1]) {
                ans = ans < 0 ? (ans - 1) : -1;
            } else {
                ans = 0;
            }
            res = Math.max(res, Math.abs(ans));
        }
        return res + 1;
    }
}