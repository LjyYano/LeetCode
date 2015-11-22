package LeetCode;

public class L098_Validate_Binary_Search_Tree {

	boolean failed = false;

	// 要用long，而不是int
	// 否则涉及到Integer.MIN_VALUE的用例会出现错误
	// 比如{Integer.MIN_VALUE}这个用例会错误
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

		// 左
		inorder(root.left);

		// 中，相当于中序遍历中的打印操作
		// 只采用了一个变量，所以空间复杂度是O(1)
		// 传统的做法是建立一个ArrayList，然后判断中序遍历是否是递增的，但是空间复杂度是O(n)
		if (last >= root.val) {
			failed = true;
		}
		last = root.val;

		// 右
		inorder(root.right);
	}
}
