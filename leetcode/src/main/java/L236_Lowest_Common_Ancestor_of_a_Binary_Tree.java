import common.TreeNode;

public class L236_Lowest_Common_Ancestor_of_a_Binary_Tree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// ����Ŀ���㣬���ǣ�left��right��
		if (root == null || root == p || root == q)
			return root;

		// �鿴���������Ƿ���Ŀ����
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// ��������ͬʱ����Ŀ���㣬��ý����lca
		if (left != null && right != null)
			return root;

		// ��������ֻ��һ������Ŀ���㣬���Ϸ���
		return left == null ? right : left;
	}
}
