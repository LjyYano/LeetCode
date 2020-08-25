import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
class L1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}