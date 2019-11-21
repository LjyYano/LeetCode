import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class L0144_Binary_Tree_Preorder_Traversal {

    // solution 1：递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(TreeNode p, List<Integer> ans) {
        // 根左右
        if (p == null) {
            return;
        }
        ans.add(p.val);
        if (p.left != null) {
            robot(p.left, ans);
        }
        if (p.right != null) {
            robot(p.right, ans);
        }
    }

    // solution 2：迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 将根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 取出栈顶元素
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                ans.add(tmp.val);
                // 将其孩子节点压入栈中（先右节点、再左节点）
                if (tmp.right != null) {
                    stack.add(tmp.right);
                }
                if (tmp.left != null) {
                    stack.add(tmp.left);
                }
            }
        }
        return ans;
    }

}
