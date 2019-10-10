import common.TreeNode;

public class L0098_Validate_Binary_Search_Tree {

	boolean failed = false;

	// Ҫ��long��������int
	// �����漰��Integer.MIN_VALUE����������ִ���
	// ����{Integer.MIN_VALUE}������������
	long last = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		inorder(root);
		return !failed;
	}

	private void inorder(TreeNode root) {

		if (root == null || failed) {
			return;
		}

		// ��
		inorder(root.left);

		// �У��൱����������еĴ�ӡ����
		// ֻ������һ�����������Կռ临�Ӷ���O(1)
		// ��ͳ�������ǽ���һ��ArrayList��Ȼ���ж���������Ƿ��ǵ����ģ����ǿռ临�Ӷ���O(n)
		if (last >= root.val) {
			failed = true;
		}
		last = root.val;

		// ��
		inorder(root.right);
	}
}
