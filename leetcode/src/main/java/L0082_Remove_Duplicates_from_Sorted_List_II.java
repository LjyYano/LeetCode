import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L0082_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		int val = head.val;

		ListNode node = head;

		boolean killme = false;
		while (node.next != null && node.next.val == val) {
			node = node.next;
			killme = true;
		}

		if (killme) {
			head = deleteDuplicates(node.next);
		} else {
			head.next = deleteDuplicates(node.next);
		}

		return head;
	
        
    }
}