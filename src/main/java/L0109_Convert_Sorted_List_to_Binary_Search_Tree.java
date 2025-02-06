import common.ListNode;
import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class L0109_Convert_Sorted_List_to_Binary_Search_Tree {

	ListNode cutAtMid(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
		ListNode pslow = head;

		while (fast != null && fast.next != null) {
			pslow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		pslow.next = null;
		return slow;
	}

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode mid = cutAtMid(head);

		TreeNode root = new TreeNode(mid.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);

		return root;
	}

}