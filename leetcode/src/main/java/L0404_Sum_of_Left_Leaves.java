import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/sum-of-left-leaves/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        robot(root, ans, false);
        return ans[0];
    }

    private void robot(TreeNode root, int[] ans, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeft) {
            ans[0] += root.val;
        }

        robot(root.left, ans, true);
        robot(root.right, ans, false);
    }
}