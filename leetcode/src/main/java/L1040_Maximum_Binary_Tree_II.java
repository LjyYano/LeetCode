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
class L1040_Maximum_Binary_Tree_II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}