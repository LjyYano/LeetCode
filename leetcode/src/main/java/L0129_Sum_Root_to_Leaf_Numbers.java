import common.TreeNode;

public class L0129_Sum_Root_to_Leaf_Numbers {

    public int sumNumbers(TreeNode root) {
        return robot(root, 0);
    }

    private int robot(TreeNode root, int p) {
        if (root == null) {
            return 0;
        }

        p = p * 10 + root.val;

        if (root.left == null && root.right == null) {
            return p;
        }

        return robot(root.left, p) + robot(root.right, p);
    }

}
