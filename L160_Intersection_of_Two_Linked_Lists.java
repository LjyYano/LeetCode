package LeetCode;

public class L160_Intersection_of_Two_Linked_Lists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		// 计算链表A的长度
		int lenA = 1;
		ListNode p = headA;
		while (p.next != null) {
			lenA++;
			p = p.next;
		}

		// 计算链表B的长度
		int lenB = 1;
		ListNode q = headB;
		while (q.next != null) {
			lenB++;
			q = q.next;
		}

		// 若A和B的最后一个结点不等，则不相交，返回null
		if (p != q) {
			return null;
		}

		// 链表按照尾部对齐
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

		// 同时向前走
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

}
