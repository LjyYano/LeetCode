import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/path-sum-iii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0437_Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return robot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int robot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        sum -= root.val;

        if (sum == 0) {
            ans++;
        }

        ans += robot(root.left, sum);
        ans += robot(root.right, sum);

        return ans;
    }
}