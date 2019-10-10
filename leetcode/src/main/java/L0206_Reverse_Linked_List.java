import common.ListNode;

public class L0206_Reverse_Linked_List {

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode tail = head.next;
		ListNode reversed = reverseList(head.next);

		// ǰ��תtail��head
		tail.next = head;
		head.next = null;

		return reversed;
	}

}
