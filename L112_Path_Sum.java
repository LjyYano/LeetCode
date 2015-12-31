package LeetCode;

public class L112_Path_Sum {

	boolean hasPath;

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		hasPath = false;
		help(root, 0, sum);
		return hasPath;
	}

	void help(TreeNode node, int cur, int sum) {

		cur += node.val;

		boolean isLeaf = (node.left == null) && (node.right == null);

		if (cur == sum && isLeaf) {
			hasPath = true;
		}

		if (node.left != null) {
			help(node.left, cur, sum);
		}

		if (node.right != null) {
			help(node.right, cur, sum);
		}

		cur -= node.val;
	}

	public boolean hasPathSum2(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return root.val == sum;
		}

		return (root.left != null && hasPathSum2(root.left, sum - root.val))
				|| (root.right != null && hasPathSum2(root.right, sum
						- root.val));
	}
}
