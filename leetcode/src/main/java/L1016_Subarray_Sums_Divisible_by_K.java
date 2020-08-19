
// https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
class L1016_Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] A, int K) {
        int mod[] = new int[K];

        int cumSum = 0;
        for (int i = 0; i < A.length; i++) {
            cumSum += A[i];
            mod[(cumSum % K + K) % K]++;
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            if (mod[i] > 1) {
                ans += (mod[i] * (mod[i] - 1)) / 2;
            }
        }

        ans += mod[0];
        return ans;
    }
}