import common.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// https://leetcode-cn.com/problems/global-and-local-inversions/
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
class L0775_Global_and_Local_Inversions {
    public List<Integer> preorder(Node root) {
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
                if (tmp.children == null) {
                    continue;
                }
                for (int i = tmp.children.size() - 1; i >= 0; i--) {
                    stack.push(tmp.children.get(i));
                }
            }
        }
        return ans;
    }
    
}