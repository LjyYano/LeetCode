package LeetCode;

public class L019_Remove_Nth_Node_From_End_of_List {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode first = head;
		ListNode second = head;

		for (int i = 0; i < n; i++) {
			first = first.next;
			if (first == null) {
				return head.next;
			}
		}

		while (first.next != null) {
			first = first.next;
			second = second.next;
		}

		second.next = second.next.next;

		return head;
	}

}
