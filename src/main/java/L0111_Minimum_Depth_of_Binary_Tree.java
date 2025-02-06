import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;
    }
}