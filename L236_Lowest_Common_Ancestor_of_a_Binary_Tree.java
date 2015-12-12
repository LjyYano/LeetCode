package LeetCode;

public class L236_Lowest_Common_Ancestor_of_a_Binary_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// 发现目标结点，则标记（left或right）
		if (root == null || root == p || root == q)
			return root;

		// 查看左右子树是否有目标结点
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// 左右子树同时含有目标结点，则该结点是lca
		if (left != null && right != null)
			return root;

		// 左右子树只有一个含有目标结点，向上返回
		return left == null ? right : left;
	}
}
