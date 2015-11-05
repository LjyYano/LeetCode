package LeetCode;

public class L024_Swap_Nodes_in_Pairs {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;

		ListNode p1 = fakeHead;
		ListNode p2 = head;

		while (p2 != null && p2.next != null) {
			ListNode nextStart = p2.next.next;
			p2.next.next = p2;
			p1.next = p2.next;
			p2.next = nextStart;
			p1 = p2;
			p2 = p2.next;
		}

		return fakeHead.next;
	}
}
