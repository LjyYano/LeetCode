import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/remove-outermost-parentheses/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1021_Remove_Outermost_Parentheses {
    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        coinsDfs(root, ans);
        return ans[0];
    }

    private int coinsDfs(TreeNode root, int[] ans) {
        if (root == null) return 0;
        int L = coinsDfs(root.left, ans);
        int R = coinsDfs(root.right, ans);
        ans[0] += Math.abs(L) + Math.abs(R);
        return root.val - 1 + Math.abs(L) + Math.abs(R);
    }
}