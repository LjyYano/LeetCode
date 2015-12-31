package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class L101_Symmetric_Tree {

	// recursively
	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		}

		return isSymmetric(root.left, root.right);
	}

	boolean isSymmetric(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}

		return p.val == q.val && isSymmetric(p.left, q.right)
				&& isSymmetric(p.right, q.left);
	}

	// iteratively
	public boolean isSymmetric2(TreeNode root) {

		if (root == null) {
			return true;
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();

		if (root.left == null && root.right == null) {
			return true;
		} else if (root.left == null || root.right == null) {
			return false;
		} else {
			deque.addLast(root.left);
			deque.addLast(root.right);
		}

		while (deque.size() != 0) {
			TreeNode p = deque.pop();
			TreeNode q = deque.pop();

			if (p.val != q.val) {
				return false;
			}

			if (p.left == null && q.right == null) {
				// do nothing
			} else if (p.left == null || q.right == null) {
				return false;
			} else {
				deque.addLast(p.left);
				deque.addLast(q.right);
			}

			if (p.right == null && q.left == null) {
				// do nothing
			} else if (p.right == null || q.left == null) {
				return false;
			} else {
				deque.addLast(p.right);
				deque.addLast(q.left);
			}
		}

		return true;
	}

}
