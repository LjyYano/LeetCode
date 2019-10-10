import common.ListNode;

public class L0142_Linked_List_Cycle_II {

	public ListNode detectCycle(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		boolean meet = false;
		int len = 0;

		// �ж��Ƿ��л���������
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

			// fast����len��
			for (int i = 0; i < len; i++) {
				fast = fast.next;
			}

			// slow����ʼ�������fast��len������
			// ���������Ľ�㣬��Ϊ�뻷���
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow;
		}

		return null;
	}

}
