package LeetCode;

public class L114_Flatten_Binary_Tree_to_Linked_List {

	TreeNode prev;

	void preorder(TreeNode root) {

		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;

		// root
		if (prev != null) {
			prev.right = root;
			prev.left = null;
		}

		prev = root;

		preorder(left);
		preorder(right);
	}

	public void flatten(TreeNode root) {
		prev = null;
		preorder(root);
	}

}