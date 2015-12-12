package LeetCode;

import java.util.Stack;

public class L230_Kth_Smallest_Element_in_a_BST {

	public int kthSmallest(TreeNode root, int k) {

		if (root == null) {
			return -1;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.isEmpty()) {

			while (p != null) {
				stack.push(p);
				p = p.left;
			}

			if (!stack.isEmpty()) {
				p = stack.pop();
				if (--k == 0) {
					return p.val;
				}
				p = p.right;
			}
		}

		return 0;
	}
}
