import java.util.Stack;

import common.TreeNode;

public class L0230_Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }

        return 0;
    }
}
