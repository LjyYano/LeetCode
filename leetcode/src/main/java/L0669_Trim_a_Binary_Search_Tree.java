import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/trim-a-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0669_Trim_a_Binary_Search_Tree {
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
        return null;
    }
    if (root.val > R) {
        return trimBST(root.left, L, R);
    }
    if (root.val < L) {
        return trimBST(root.right, L, R);
    }

    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
}
}