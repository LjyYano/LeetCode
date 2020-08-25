import java.util.Arrays;

// https://leetcode-cn.com/problems/flower-planting-with-no-adjacent/
class L1042_Flower_Planting_With_No_Adjacent {
    public int mergeStones(int[] stones, int K) {
        if (stones.length < K) {
            return 0;
        }
        
        int[] sums = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            if (i == 0) {
                sums[i] = stones[i];
            } else {
                sums[i] = sums[i - 1] + stones[i];
            }
        }

        int ans = 0;

        // 找到连续K的最小和
        while (true) {

            if (sums.length < K) {
                return -1;
            }
            int min = sums[K - 1];
            int pos = K - 1;
            for (int i = K; i < sums.length; i++) {
                int tmpSum = sums[i] - sums[i - K];
                if (tmpSum < min) {
                    min = tmpSum;
                    pos = i;
                }
            }

            ans += min;
            // 删除[pos-K+1, pos-1]
            for (int i = pos - K + 1; i < sums.length + 1 - K; i++) {
                sums[i] = sums[i + K - 1];
            }

            sums = Arrays.copyOf(sums, sums.length - K + 1);

            if (sums.length == 1) {
                return ans;
            }
        }
    }
}