package LeetCode;

public class L203_Remove_Linked_List_Elements {

	public static ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy;
		ListNode q = head;

		while (q != null) {
			if (q.val == val) {
				p.next = q.next;
			} else {
				p = p.next;
			}
			q = q.next;
		}

		return dummy.next;
	}

}
