import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/house-robber-iii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0337_House_Robber_III {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        return Math.max(robIn(root), robEx(root));
    }
    
    private int robIn(TreeNode root) {
        if(root == null) return 0;
        return root.val + robEx(root.left) + robEx(root.right);
    }
    
    private int robEx(TreeNode root) {
        if(root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
}