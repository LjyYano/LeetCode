import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0998_Check_Completeness_of_a_Binary_Tree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        if (root.right != null && isLeaf(root.right) && root.left == null) return false;
        return isCompleteTree(root.left) && isCompleteTree(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}