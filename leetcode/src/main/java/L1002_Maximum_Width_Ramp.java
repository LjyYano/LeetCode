import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/maximum-width-ramp/
class L1002_Maximum_Width_Ramp {
    public int maxWidthRamp(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                left[i] = A[i];
            } else {
                left[i] = Math.min(left[i - 1], A[i]);
            }
            if (!leftMap.containsKey(A[i])) {
                leftMap.put(A[i], i);
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                right[i] = A[i];
            } else {
                right[i] = Math.max(right[i + 1], A[i]);
            }
            if (!rightMap.containsKey(A[i])) {
                rightMap.put(A[i], i);
            }
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            if (right[i] > left[i]) {
                ans = Math.max(rightMap.get(right[i]) - leftMap.get(left[i]), ans);
            } else {
                break;
            }
        }

        return ans;
    }
}