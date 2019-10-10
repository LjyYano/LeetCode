import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class L0094_Binary_Tree_Inorder_Traversal {

    // solution 1：递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        // 左根右
        robot(root.left, ans);
        ans.add(root.val);
        robot(root.right, ans);
    }

    // solution 2：迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
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
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
