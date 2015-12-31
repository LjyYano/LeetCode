package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144_Binary_Tree_Preorder_Traversal {

	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> rt = new ArrayList<Integer>();

		if (root == null) {
			return rt;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			while (p != null) {
				rt.add(p.val);
				stack.push(p);
				p = p.left;
			}

			if (!stack.empty()) {
				p = stack.pop();
				p = p.right;
			}
		}

		return rt;
	}

}
