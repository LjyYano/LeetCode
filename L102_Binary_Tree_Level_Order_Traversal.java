package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L102_Binary_Tree_Level_Order_Traversal {

	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Deque<TreeNode> deque = new LinkedList<TreeNode>();

		int curLevel = 0;
		int nextLevel = 0;

		List<Integer> level = new LinkedList<Integer>();

		level.add(root.val);
		result.add(new ArrayList<Integer>(level));
		level.clear();

		if (root.left != null) {
			deque.addLast(root.left);
			curLevel++;
		}

		if (root.right != null) {
			deque.addLast(root.right);
			curLevel++;
		}

		while (!deque.isEmpty()) {

			TreeNode p = deque.poll();
			level.add(p.val);
			curLevel--;

			if (p.left != null) {
				deque.addLast(p.left);
				nextLevel++;
			}

			if (p.right != null) {
				deque.addLast(p.right);
				nextLevel++;
			}

			if (curLevel == 0) {
				curLevel = nextLevel;
				nextLevel = 0;
				result.add(new ArrayList<Integer>(level));
				level.clear();
			}

		}

		return result;
	}

	public static List<List<Integer>> levelOrder2(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		final TreeNode END = new TreeNode(0);

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		List<Integer> level = new LinkedList<Integer>();

		deque.add(root);
		deque.add(END);

		while (!deque.isEmpty()) {

			TreeNode p = deque.pop();

			if (p == END) {
				result.add(new ArrayList<Integer>(level));
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

		return result;
	}
}
