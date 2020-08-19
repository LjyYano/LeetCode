
// https://leetcode-cn.com/problems/clumsy-factorial/
class L1048_Clumsy_Factorial {
    public int clumsy(int N) {
        int ans = 0;
        int add = N - 3;
        while (add > 0) {
            ans += add;
            add -= 4;
        }

        ans += calc3(N);
        N -= 4;
        while (N > 0) {
            ans -= calc3(N);
            N -= 4;
        }

        return ans;
    }

    private int calc3(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return n * (n - 1) / (n - 2);
    }
}