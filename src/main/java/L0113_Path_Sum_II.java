import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/path-sum-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        robot(root, sum, ans, new ArrayList<>());
        return ans;
    }

    private void robot(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        robot(root.left, sum - root.val, ans, tmp);
        robot(root.right, sum - root.val, ans, tmp);
        tmp.remove(tmp.size() - 1);
    }
}