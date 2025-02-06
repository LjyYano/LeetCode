import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0124_Binary_Tree_Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[] { Integer.MIN_VALUE };
        robot(root, ans);
        return ans[0];
    }

    private int robot(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int left = robot(root.left, ans);
        int right = robot(root.right, ans);

        int res = root.val;
        if (Math.max(left, right) > 0) {
            res += Math.max(left, right);
        }

        int gain = Math.max(Math.max(left, right), left + right);

        ans[0] = Math.max(ans[0], root.val);
        ans[0] = Math.max(ans[0], root.val + gain);
        return res;
    }
}