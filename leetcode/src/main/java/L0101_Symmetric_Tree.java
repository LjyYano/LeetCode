import common.Node;
import java.util.Stack;
import common.TreeNode;

// https://leetcode-cn.com/problems/symmetric-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();

            if (p == null && q == null) {
                continue;
            }

            if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            stack.push(p.left);
            stack.push(q.right);

            stack.push(p.right);
            stack.push(q.left);
        }

        return true;
    }
}