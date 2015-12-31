package LeetCode;

public class L111_Minimum_Depth_of_Binary_Tree {

	public int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else if (root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		}

		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

}
