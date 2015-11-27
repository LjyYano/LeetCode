package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class L113_Path_Sum_II {

	List<List<Integer>> result;
	List<Integer> path;
	int sum;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		result = new ArrayList<List<Integer>>();
		path = new ArrayList<Integer>();
		this.sum = sum;

		if (root == null) {
			return result;
		}

		help(root, 0);

		return result;
	}

	void help(TreeNode node, int cur) {

		cur += node.val;
		path.add(node.val);

		boolean isLeaf = (node.left == null) && (node.right == null);

		if (cur == sum && isLeaf) {
			result.add(new ArrayList<Integer>(path));
		}

		if (node.left != null) {
			help(node.left, cur);
		}

		if (node.right != null) {
			help(node.right, cur);
		}

		cur -= node.val;
		path.remove(path.size() - 1);
	}

}
