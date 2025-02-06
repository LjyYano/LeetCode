import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/sort-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L0148_Sort_List {	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode rt = new ListNode(0);
		ListNode h = rt;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				rt.next = l1;
				l1 = l1.next;
			} else {
				rt.next = l2;
				l2 = l2.next;
			}

			rt = rt.next;
		}

		if (l1 != null)
			rt.next = l1;
		else
			rt.next = l2;

		return h.next;

	}

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode fast = head.next;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode h2 = slow.next;
		slow.next = null;

		return mergeTwoLists(sortList(head), sortList(h2));

	}}