import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/maximum-binary-tree-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0998_Maximum_Binary_Tree_II {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        if (root.right != null && isLeaf(root.right) && root.left == null) return false;
        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}