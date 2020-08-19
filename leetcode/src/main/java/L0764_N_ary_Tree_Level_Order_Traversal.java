import common.Node;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
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
class L0764_N_ary_Tree_Level_Order_Traversal {
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
}