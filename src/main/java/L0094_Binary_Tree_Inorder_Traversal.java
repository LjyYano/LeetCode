import common.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0094_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 一直放入左儿子（左）
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 访问当前元素（根），把右儿子入栈（右）
            if (stack.size() != 0) {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}