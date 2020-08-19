import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/binary-tree-cameras/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1008_Binary_Tree_Cameras {
    
    private static final int NOT_COVERED = 0;
    private static final int CAMERA = 1;
    private static final int COVERED = 2;

    // 0 = not covered
    // 1 = has camera
    // 2 = covered by camera (no camera)

    int ans;

    public int minCameraCover(TreeNode root) {
        int state = helper(root);
        if (state == NOT_COVERED) ans++;
        return ans;
    }

    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) return NOT_COVERED;
        boolean needCamera = false, covered = false;

        if (root.left != null) {
            int state = helper(root.left);
            if (state == NOT_COVERED) needCamera = true;
            if (state == CAMERA) covered = true;
        }

        if (root.right != null) {
            int state = helper(root.right);
            if (state == NOT_COVERED) needCamera = true;
            if (state == CAMERA) covered = true;
        }

        if (needCamera) {
            ans++;
            return CAMERA;
        }

        if (covered) {
            return COVERED;
        }

        return NOT_COVERED;
    }
}