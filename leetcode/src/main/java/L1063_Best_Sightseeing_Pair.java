
// https://leetcode-cn.com/problems/best-sightseeing-pair/
class L1063_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] -= i;
        }

        int[] rightMax = new int[A.length];
        rightMax[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            ans = Math.max(ans, A[i] + rightMax[i + 1] + 2 * i);
        }

        return ans;
    }
}