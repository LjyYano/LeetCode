import common.TreeNode;

public class L0124_Binary_Tree_Maximum_Path_Sum {

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[] { Integer.MIN_VALUE };
        robot(root, ans);
        return ans[0];
    }

    private int robot(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int left = robot(root.left, ans);
        int right = robot(root.right, ans);

        int res = root.val;
        if (Math.max(left, right) > 0) {
            res += Math.max(left, right);
        }

        int gain = Math.max(Math.max(left, right), left + right);

        ans[0] = Math.max(ans[0], root.val);
        ans[0] = Math.max(ans[0], root.val + gain);
        return res;
    }
}
