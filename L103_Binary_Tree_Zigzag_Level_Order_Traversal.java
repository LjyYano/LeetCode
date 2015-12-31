package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> rt = new ArrayList<List<Integer>>();

		if (root == null) {
			return rt;
		}

		final TreeNode END = new TreeNode(0);

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		List<Integer> level = new LinkedList<Integer>();
		int count = 0;

		deque.add(root);
		deque.add(END);

		while (!deque.isEmpty()) {

			TreeNode p = deque.pop();

			if (p == END) {

				if (count % 2 == 1) {
					Collections.reverse(level);
				}

				count++;

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
