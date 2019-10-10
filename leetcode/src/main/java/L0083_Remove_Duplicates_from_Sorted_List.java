import common.ListNode;

public class L0083_Remove_Duplicates_from_Sorted_List {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode node = head;

		while (node.next != null) {

			// ���Ԫ�ز��ظ�������
			if (node.val != node.next.val) {
				node = node.next;
			} else {
				// �ظ�����������һ��
				while (node.next != null && node.val == node.next.val) {
					node.next = node.next.next;
				}
			}
		}

		return head;
	}

}
