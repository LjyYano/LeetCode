import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-paths/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        robot(root, ans, "");
        return ans;
    }

    private void robot(TreeNode root, List<String> ans, String path) {
        if (root == null) {
			return;
		}
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }
        robot(root.left, ans, path + root.val + "->");
        robot(root.right, ans, path + root.val + "->");
    }
}