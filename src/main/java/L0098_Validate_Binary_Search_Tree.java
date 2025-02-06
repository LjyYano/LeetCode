import common.Node;
import java.util.Stack;
import common.TreeNode;

// https://leetcode-cn.com/problems/validate-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0098_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 一直放入左儿子（左）
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 访问当前元素（根），把右儿子入栈（右）
            if (!stack.isEmpty()) {
                root = stack.pop();

                // 若 root.val <= min，则该树不是 BST
                if (root.val <= min) {
                    return false;
                }
                min = root.val;
                root = root.right;
            }
        }
        return true;
    }
}