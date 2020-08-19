import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0662_Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        robot(root, ans, new ArrayList<>(), 0, 1);
        return ans[0];
    }

    private void robot(TreeNode root, int[] ans, ArrayList<Integer> leftIndexes, int level,
            int index) {
        if (root == null) {
            return;
        }

        if (leftIndexes.size() <= level) {
            leftIndexes.add(index);
        }

        ans[0] = Math.max(ans[0], index - leftIndexes.get(level) + 1);
        robot(root.left, ans, leftIndexes, level + 1, 2 * index);
        robot(root.right, ans, leftIndexes, level + 1, 2 * index + 1);
    }
}