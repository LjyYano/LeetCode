import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/closest-leaf-in-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0743_Closest_Leaf_in_a_Binary_Tree {
	public int findClosestLeaf(TreeNode root, int k) {
		// 找到k在哪一层
		int level = getLevel(root, k, 0);
		// 层序遍历，找到>=level层的叶子节点，返回即可
		return robot(root, level, 0);
	}

	private int robot(TreeNode root, int level, int curLevel) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		// 是叶子节点
		if (root.left == null && root.right == null && curLevel >= level) {
			return root.val;
		}

		int left = robot(root.left, level, curLevel + 1);
		int right = robot(root.right, level, curLevel + 1);
		if (left == Integer.MIN_VALUE) {
			return right;
		}
		if (right == Integer.MIN_VALUE) {
			return left;
		}
		if (getLevel(root, left, 0) < getLevel(root, right, 0)) {
			return left;
		} else {
			return right;
		}
	}

	private int getLevel(TreeNode root, int k, int level) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		if (root.val == k) {
			return level;
		}

		int left = getLevel(root.left, k, level + 1);
		int right = getLevel(root.right, k, level + 1);
		return Math.max(left, right);
	}
}