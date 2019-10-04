import common.TreeNode;

public class L1123_Lowest_Common_Ancestor_of_Deepest_Leaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            return root;
        }

        return left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left, right) + 1;
    }
}
