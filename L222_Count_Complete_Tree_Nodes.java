package LeetCode;

public class L222_Count_Complete_Tree_Nodes {

	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftHeight = 0;
		int rightHeight = 0;

		// 计算leftHeight
		TreeNode p = root;
		while (p != null) {
			p = p.left;
			leftHeight++;
		}

		// 计算rightHeight
		p = root;
		while (p != null) {
			p = p.right;
			rightHeight++;
		}

		// 如果相等，满足2^n-1
		if (leftHeight == rightHeight) {
			return (1 << leftHeight) - 1;
		}

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
