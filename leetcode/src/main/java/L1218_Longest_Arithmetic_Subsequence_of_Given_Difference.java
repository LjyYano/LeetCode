import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1218_Longest_Arithmetic_Subsequence_of_Given_Difference {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            return root;
        }

        return left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left, right) + 1;
    }
}