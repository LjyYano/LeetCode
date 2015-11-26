package LeetCode;

public class L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	int p = 0;
	int[] preorder;
	int[] inorder;

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		this.preorder = preorder;
		this.inorder = inorder;

		return buildTree(0, preorder.length);
	}

	TreeNode buildTree(int start, int end) {

		if (start >= end) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[p]);

		int i;
		for (i = start; i < end && preorder[p] != inorder[i]; i++)
			;

		p++;
		root.left = buildTree(start, i);
		root.right = buildTree(i + 1, end);

		return root;
	}
}
