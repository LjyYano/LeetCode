import common.TreeNode;

public class L0563_Binary_Tree_Tilt {

    public int findTilt(TreeNode root) {
        int[] ans = new int[1];
        robot(root, ans);
        return ans[0];

    }

    private int robot(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left = robot(root.left, ans);
        int right = robot(root.right, ans);
        ans[0] += Math.abs(left - right);
        return left + right + root.val;
    }
}
