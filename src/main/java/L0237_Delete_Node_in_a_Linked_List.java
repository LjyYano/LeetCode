import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class L0237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
		
		if (node == null) {
			return;
		}

		node.val = node.next.val;
		node.next = node.next.next;
	
        
    }
}