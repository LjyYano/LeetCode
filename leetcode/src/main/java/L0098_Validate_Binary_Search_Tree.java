import java.util.Stack;

import common.TreeNode;

public class L0098_Validate_Binary_Search_Tree {

    // 递归
    public boolean isValidBST(TreeNode root) {
        // 用long型
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 迭代
    public boolean isValidBST2(TreeNode root) {
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
