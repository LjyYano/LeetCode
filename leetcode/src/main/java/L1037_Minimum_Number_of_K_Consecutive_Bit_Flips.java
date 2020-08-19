
// https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/
class L1037_Minimum_Number_of_K_Consecutive_Bit_Flips {
    public int minKBitFlips(int[] A, int K) {
        int step = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                continue;
            }

            // 如果接下来够K个数
            if (A.length - i < K) {
                return -1;
            }

            // 翻转接下来的K个数
            for (int j = 0; j < K; j++) {
                A[i + j] = A[i + j] == 0 ? 1 : 0;
            }
            step++;
        }
        return step;
    }
}