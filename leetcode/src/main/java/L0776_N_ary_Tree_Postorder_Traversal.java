import common.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class L0776_N_ary_Tree_Postorder_Traversal {
    // 后续遍历：左右中
    // 迭代顺序：中右左
    public List<Integer> postorder(Node root) {
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