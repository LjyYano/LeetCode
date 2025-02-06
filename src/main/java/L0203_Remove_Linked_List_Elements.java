import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/remove-linked-list-elements/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L0203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy;
		ListNode q = head;

		while (q != null) {
			if (q.val == val) {
				p.next = q.next;
			} else {
				p = p.next;
			}
			q = q.next;
		}

		return dummy.next;
	
        
    }
}