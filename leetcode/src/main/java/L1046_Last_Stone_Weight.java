import java.util.List;

// https://leetcode-cn.com/problems/last-stone-weight/
class L1046_Last_Stone_Weight {
    public int longestOnes(int[] A, int K) {
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0, l = 0;
        for (int r = 0; r < A.length; r++) {
            if (A[r] == 0) queue.offer(r);
            if (queue.size() > K) {
                l = queue.poll() + 1;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}