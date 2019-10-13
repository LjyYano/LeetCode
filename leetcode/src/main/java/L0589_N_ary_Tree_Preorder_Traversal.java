import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.Node;

public class L0589_N_ary_Tree_Preorder_Traversal {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        if (root.children == null) {
            return;
        }

        for (Node child : root.children) {
            robot(child, ans);
        }
    }

    // 迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        // 将根节点入栈
        stack.push(root);

        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            if (tmp != null) {
                // 打印结果
                ans.add(tmp.val);

                List<Node> children = tmp.children;
                if (children == null) {
                    continue;
                }
                // 从右到左，依次将子节点入栈
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return ans;
    }
}
