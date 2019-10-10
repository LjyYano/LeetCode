import common.TreeNode;

public class L0543_Diameter_of_Binary_Tree {

    public int diameterOfBinaryTree(TreeNode root) {
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

        // 维护直径最大值
        ans[0] = Math.max(left + right, ans[0]);

        // 返回当前节点的最大直径
        return Math.max(left, right) + 1;
    }
}
