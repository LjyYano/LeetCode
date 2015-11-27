package LeetCode;

public class L106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	int p;
	int[] postorder;
	int[] inorder;

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		this.p = postorder.length - 1;
		this.inorder = inorder;
		this.postorder = postorder;

		return buildTree(0, postorder.length);
	}

	TreeNode buildTree(int start, int end) {

		if (start >= end) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[p]);

		int i;
		for (i = start; i < end && postorder[p] != inorder[i]; i++)
			;

		p--;
		root.right = buildTree(i + 1, end);
		root.left = buildTree(start, i);

		return root;
	}

}
