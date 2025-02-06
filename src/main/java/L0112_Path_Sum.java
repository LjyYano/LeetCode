import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
			return false;
		}
        
        // 叶子节点 && 和为 sum
        if (root.left == null && root.right == null && sum - root.val == 0) {
			return true;
		}
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}