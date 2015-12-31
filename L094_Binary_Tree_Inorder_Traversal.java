package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L094_Binary_Tree_Inorder_Traversal {

	List<Integer> rt = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {

		rt.clear();
		inorder(root);
		return rt;
	}

	void inorder(TreeNode node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		rt.add(node.val);
		inorder(node.right);
	}

}
