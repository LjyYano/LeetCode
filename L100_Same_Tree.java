package LeetCode;

public class L100_Same_Tree {

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}

		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

}
