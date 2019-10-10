import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class L0145_Binary_Tree_Postorder_Traversal {

    // solution 1：递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(TreeNode p, List<Integer> ans) {
        if (p == null) {
            return;
        }
        // 左右根
        robot(p.left, ans);
        robot(p.right, ans);
        ans.add(p.val);
    }

    // solution 2：迭代
    public static class StackNode {
        TreeNode root;
        boolean visit;

        StackNode(TreeNode root) {
            this.root = root;
        }
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<StackNode> stack = new Stack<>();
        StackNode node;
        stack.push(new StackNode(root));
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node == null) {
                continue;
            }
            if (!node.visit) {
                node.visit = true;
                stack.push(node);
                if (node.root.right != null) {
                    stack.push(new StackNode(node.root.right));
                }
                if (node.root.left != null) {
                    stack.push(new StackNode(node.root.left));
                }
            } else if (node.root != null) {
                ans.add(node.root.val);
            }
        }
        return ans;
    }

    // solution 3：迭代，逆序输出
    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }


}
