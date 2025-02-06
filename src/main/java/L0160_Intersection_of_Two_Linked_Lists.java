import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class L0160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int lenA = 1;
		ListNode p = headA;
		while (p.next != null) {
			lenA++;
			p = p.next;
		}

		int lenB = 1;
		ListNode q = headB;
		while (q.next != null) {
			lenB++;
			q = q.next;
		}

		if (p != q) {
			return null;
		}

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

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	
        
    }
}