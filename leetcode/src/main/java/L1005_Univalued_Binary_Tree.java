import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/univalued-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1005_Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}