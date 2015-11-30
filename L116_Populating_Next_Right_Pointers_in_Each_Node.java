package LeetCode;

public class L116_Populating_Next_Right_Pointers_in_Each_Node {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		if (root.left != null && root.right != null) {
			root.left.next = root.right;
		}

		if (root.next != null && root.next.left != null) {
			root.right.next = root.next.left;
		}

		connect(root.left);
		connect(root.right);
	}
}
