package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L102_Binary_Tree_Level_Order_Traversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (root == null) {
			return rt;
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);

		int toBePrinted = 1;
		int nextLevel = 0;

		List<Integer> level = new LinkedList<Integer>();

		while (!deque.isEmpty()) {

			TreeNode p = deque.poll();
			level.add(p.val);
			toBePrinted--;

			if (p.left != null) {
				deque.addLast(p.left);
				nextLevel++;
			}

			if (p.right != null) {
				deque.addLast(p.right);
				nextLevel++;
			}

			if (toBePrinted == 0) {
				toBePrinted = nextLevel;
				nextLevel = 0;
				rt.add(new ArrayList<Integer>(level));
				level.clear();
			}

		}

		return rt;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {

		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (root == null) {
			return rt;
		}

		final TreeNode END = new TreeNode(0);

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		List<Integer> level = new LinkedList<Integer>();

		deque.add(root);
		deque.add(END);

		while (!deque.isEmpty()) {

			TreeNode p = deque.pop();

			if (p == END) {
				rt.add(new ArrayList<Integer>(level));
				level.clear();

				if (!deque.isEmpty()) {
					deque.add(END);
				}
			} else {
				level.add(p.val);

				if (p.left != null) {
					deque.add(p.left);
				}

				if (p.right != null) {
					deque.add(p.right);
				}
			}
		}

		return rt;
	}
}
