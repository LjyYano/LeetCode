import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/recover-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0099_Recover_Binary_Search_Tree {
    TreeNode first = null, second = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        robot(root);
        if(first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    private void robot(TreeNode root) {
        if(root == null) return;
        robot(root.left);
        // 找到交换的两个节点
        if(first == null && pre.val > root.val) {
            first = pre;
        }
        if(first != null && pre.val > root.val) {
            second = root;
        }
        pre = root;
        robot(root.right);
    }
}