package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L094_Binary_Tree_Inorder_Traversal {

	List<Integer> result = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {

		result.clear();
		inorder(root);
		return result;
	}

	void inorder(TreeNode node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		result.add(node.val);
		inorder(node.right);
	}

}
