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
        if (p == null) {
            return;
        }
        // 根左右
        ans.add(p.val);
        robot(p.left, ans);
        robot(p.right, ans);
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
                stack.add(tmp.right);
                stack.add(tmp.left);
            }
        }
        return ans;
    }

}
