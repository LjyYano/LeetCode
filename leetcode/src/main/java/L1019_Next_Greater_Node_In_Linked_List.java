import common.Node;
import java.util.Arrays;

// https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
class L1019_Next_Greater_Node_In_Linked_List {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }
}