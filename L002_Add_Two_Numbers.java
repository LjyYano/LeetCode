package LeetCode;

public class L002_Add_Two_Numbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode p1 = l1;
		ListNode p2 = l2;

		int carry = 0;

		ListNode head = new ListNode(0);
		ListNode result = head;

		while (carry != 0 || p1 != null || p2 != null) {

			int v1 = 0;
			if (p1 != null) {
				v1 = p1.val;
				p1 = p1.next;
			}

			int v2 = 0;
			if (p2 != null) {
				v2 = p2.val;
				p2 = p2.next;
			}

			int tmp = v1 + v2 + carry;
			carry = tmp / 10;
			head.next = new ListNode(tmp % 10);
			head = head.next;
		}

		return result.next;
	}
}
