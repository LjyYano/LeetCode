import java.util.Arrays;

// https://leetcode-cn.com/problems/squares-of-a-sorted-array/
class L1019_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }
}