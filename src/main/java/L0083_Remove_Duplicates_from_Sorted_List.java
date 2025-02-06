import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
			if (node.val != node.next.val) {
				node = node.next;
			} else {
				while (node.next != null && node.val == node.next.val) {
					node.next = node.next.next;
				}
			}
		}

		return head;

	
        
    }
}