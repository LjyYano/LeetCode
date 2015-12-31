package LeetCode;

public class L141_Linked_List_Cycle {

	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {

			if (fast.next == null || fast.next.next == null) {
				return false;
			}

			if (slow == fast) {
				return true;
			}

			fast = fast.next.next;
			slow = slow.next;
		}

		return false;
	}

}
