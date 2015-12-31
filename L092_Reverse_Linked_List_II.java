package LeetCode;

public class L092_Reverse_Linked_List_II {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;

		// 先向后移m步
		ListNode pre = fakeHead;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		// 对后面的n-m个结点，逆置
		ListNode mNode = pre.next;
		for (int i = m; i < n; i++) {
			ListNode cur = mNode.next;
			mNode.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}

		return fakeHead.next;
	}

}
