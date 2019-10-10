import common.ListNode;

public class L0160_Intersection_of_Two_Linked_Lists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		// ��������A�ĳ���
		int lenA = 1;
		ListNode p = headA;
		while (p.next != null) {
			lenA++;
			p = p.next;
		}

		// ��������B�ĳ���
		int lenB = 1;
		ListNode q = headB;
		while (q.next != null) {
			lenB++;
			q = q.next;
		}

		// ��A��B�����һ����㲻�ȣ����ཻ������null
		if (p != q) {
			return null;
		}

		// ������β������
		if (lenA > lenB) {
			int t = lenA - lenB;
			while (t-- != 0) {
				headA = headA.next;
			}
		} else {
			int t = lenB - lenA;
			while (t-- != 0) {
				headB = headB.next;
			}
		}

		// ͬʱ��ǰ��
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

}
