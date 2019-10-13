import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.Node;

public class L0429_N_ary_Tree_Level_Order_Traversal {

    // 递归
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        robot(root, ans, 0);
        return ans;
    }

    private void robot(Node root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);

        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            robot(child, ans, level + 1);
        }
    }

    // 迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            if (tmp != null) {
                ans.add(tmp.val);
                List<Node> children = tmp.children;
                if (children == null) {
                    continue;
                }
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return ans;
    }
}
