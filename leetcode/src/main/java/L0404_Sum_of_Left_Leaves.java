import common.TreeNode;

public class L0404_Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        robot(root, ans, false);
        return ans[0];
    }

    private void robot(TreeNode root, int[] ans, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeft) {
            ans[0] += root.val;
        }

        robot(root.left, ans, true);
        robot(root.right, ans, false);
    }
}
