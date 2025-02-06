import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        robot(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }
    
    private void robot(TreeNode root, int level, List<List<Integer>> ans) {
        if(root == null) return;
        if(ans.size() <= level) {
            ans.add(new ArrayList());
        }
        
        ans.get(level).add(root.val);
        robot(root.left, level + 1, ans);
        robot(root.right, level + 1, ans);
    }
}