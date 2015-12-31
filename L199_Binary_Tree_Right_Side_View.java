package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L199_Binary_Tree_Right_Side_View {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> rt = new ArrayList<Integer>();

		if (root == null) {
			return rt;
		}

		rt.add(root.val);

		List<Integer> left = rightSideView(root.left);
		List<Integer> right = rightSideView(root.right);

		rt.addAll(right);

		if (left.size() > right.size()) {
			rt.addAll(left.subList(right.size(), left.size()));
		}

		return rt;

	}

	public List<Integer> rightSideView2(TreeNode root) {

		List<Integer> rt = new ArrayList<Integer>();
		if (root == null) {
			return rt;
		}

		final TreeNode END = new TreeNode(0);

		Deque<TreeNode> deque = new LinkedList<TreeNode>();

		deque.add(root);
		deque.add(END);

		while (!deque.isEmpty()) {

			TreeNode p = deque.pop();

			if (p == END) {
				if (!deque.isEmpty()) {
					deque.add(END);
				}
			} else {

				// 如果deque的下一个是END，则p是层序的最后一个，加入结果rt
				if (deque.peek() == END) {
					rt.add(p.val);
				}

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

	public List<Integer> rightSideView3(TreeNode root) {

		List<Integer> rt = new ArrayList<Integer>();

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
				rt.add(p.val);
				level.clear();
			}

		}

		return rt;
	}

}
