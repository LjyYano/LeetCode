package LeetCode;

public class L206_Reverse_Linked_List {

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode tail = head.next;
		ListNode reversed = reverseList(head.next);

		// 前后翻转tail和head
		tail.next = head;
		head.next = null;

		return reversed;
	}

}
