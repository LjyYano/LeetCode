import java.util.Stack;

import common.TreeNode;

public class L0101_Symmetric_Tree {

    // recursively
    public boolean isSymmetric(TreeNode root) {
        return robot(root, root);
    }

    boolean robot(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && robot(p.left, q.right) && robot(p.right, q.left);
    }

    // iteratively
    public boolean isSymmetric2(TreeNode root) {

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
