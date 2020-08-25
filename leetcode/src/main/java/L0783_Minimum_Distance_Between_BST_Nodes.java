import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0783_Minimum_Distance_Between_BST_Nodes {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return null;
    }
}