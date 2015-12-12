package LeetCode;

public class L235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || p == null || q == null) {
			return null;
		}

		int m = Math.min(p.val, q.val);
		int n = Math.max(p.val, q.val);

		while (root != null) {
			if (root.val < m) {
				root = root.right;
			} else if (root.val > n) {
				root = root.left;
			} else {
				return root;
			}
		}

		return null;
	}

}
