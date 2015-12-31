package LeetCode;

public class L142_Linked_List_Cycle_II {

	public ListNode detectCycle(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		boolean meet = false;
		int len = 0;

		// 判断是否有环，并计数
		while (fast != null) {

			if (fast.next == null || fast.next.next == null) {
				return null;
			}

			if (slow == fast) {
				if (meet) {
					break;
				}
				meet = true;
			}

			fast = fast.next.next;
			slow = slow.next;

			if (meet) {
				len++;
			}
		}

		if (meet) {

			slow = head;
			fast = head;

			// fast先走len步
			for (int i = 0; i < len; i++) {
				fast = fast.next;
			}

			// slow从起始点出发，fast从len处出发
			// 二者相遇的结点，即为入环结点
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow;
		}

		return null;
	}

}
