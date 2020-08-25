
// https://leetcode-cn.com/problems/longest-arithmetic-subsequence/
class L1027_Longest_Arithmetic_Subsequence {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int s = 0;
        int[] ans = new int[queries.length];

        for (int a : A) {
            if (a % 2 == 0) {
                s += a;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int add =queries[i][0];
            int pos = queries[i][1];
            int before = A[pos];
            A[pos] = before + add;
            // 以前是偶数
            if (before % 2 == 0) {
                if (A[pos] % 2 == 0) {
                    s += add;
                } else {
                    s = s - before;
                }
            } else {
                // 以前是奇数，现在是偶数
                if (A[pos] % 2 == 0) {
                    s += A[pos];
                }
            }
            ans[i] = s;
        }

        return ans;
    }
}