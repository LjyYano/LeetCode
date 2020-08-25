import java.util.Arrays;

// https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
class L1018_Binary_Prefix_Divisible_By_5 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}