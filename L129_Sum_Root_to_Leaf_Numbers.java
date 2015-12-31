package LeetCode;

public class L129_Sum_Root_to_Leaf_Numbers {

	int sumNumbers(TreeNode root, int parentval) {

		if (root == null) {
			return 0;
		}

		int p = parentval * 10 + root.val;

		if (root.left == null && root.right == null) {
			return p;
		}

		return sumNumbers(root.left, p) + sumNumbers(root.right, p);
	}

}
