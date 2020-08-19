import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0129_Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        return robot(root, 0);
    }

    private int robot(TreeNode root, int p) {
        if (root == null) {
            return 0;
        }

        p = p * 10 + root.val;

        if (root.left == null && root.right == null) {
            return p;
        }

        return robot(root.left, p) + robot(root.right, p);
    }
}