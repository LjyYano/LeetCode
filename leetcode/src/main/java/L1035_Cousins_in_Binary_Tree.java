import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/cousins-in-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1035_Cousins_in_Binary_Tree {
    int depthX = 0, depthY = 0;
    int parentX = 0, parentY = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        isCousinsDfs(root, root, x, y, 0);
        return (parentX != parentY) && (depthX == depthY);
    }

    private void isCousinsDfs(TreeNode parent, TreeNode cur, int x, int y, int depth) {
        if (cur == null) return;
        if (cur.val == x) {
            parentX = parent.val;
            depthX = depth;
        } else if (cur.val == y) {
            parentY = parent.val;
            depthY = depth;
        }

        isCousinsDfs(cur, cur.left, x, y, depth + 1);
        isCousinsDfs(cur, cur.right, x, y, depth + 1);
    }
}