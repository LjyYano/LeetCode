import common.TreeNode;

public class L0104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

}
