package LeetCode;

public class L021_Merge_Two_Sorted_Lists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p = new ListNode(0);
		ListNode head = p;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		if (l1 != null) {
			p.next = l1;
		} else {
			p.next = l2;
		}

		return head.next;
	}
}
