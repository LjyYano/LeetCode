import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1030_Matrix_Cells_in_Distance_Order {
    String ret = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return ret;
    }

    void dfs(TreeNode cur, String s) {
        if(cur == null) return;
        s = (char)('a' + cur.val) + s;
        if(cur.left == null && cur.right == null){
            if(s.compareTo(ret) < 0){
                ret = s;
            }
        }
        dfs(cur.left, s);
        dfs(cur.right, s);
    }
}