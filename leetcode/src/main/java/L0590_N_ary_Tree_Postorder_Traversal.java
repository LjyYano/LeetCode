import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import common.Node;

public class L0590_N_ary_Tree_Postorder_Traversal {

    // 递归
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child : root.children) {
                robot(child, ans);
            }
        }
        ans.add(root.val);
    }

    // 迭代
    // 后续遍历：左右中
    // 迭代顺序：中右左
    public List<Integer> postorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            ans.add(pop.val);
            List<Node> children = pop.children;
            if (children == null) {
                continue;
            }
            for (Node child : children) {
                stack.push(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
