import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0144_Binary_Tree_Preorder_Traversal {
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
}