package LeetCode;

public class L104_Maximum_Depth_of_Binary_Tree {

	public int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int nLeft = maxDepth(root.left);
		int nRight = maxDepth(root.right);

		return nLeft > nRight ? (nLeft + 1) : (nRight + 1);
	}

}
