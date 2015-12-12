package LeetCode;

public class L226_Invert_Binary_Tree {

	public TreeNode invertTree(TreeNode root) {

		if ((root == null) || (root.left == null && root.right == null)) {
			return root;
		}

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		if (root.left != null) {
			invertTree(root.left);
		}

		if (root.right != null) {
			invertTree(root.right);
		}

		return root;
	}
}
