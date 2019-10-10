import common.ListNode;

public class L0092_Reverse_Linked_List_II {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;

		// �������m��
		ListNode pre = fakeHead;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		// �Ժ����n-m����㣬����
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
