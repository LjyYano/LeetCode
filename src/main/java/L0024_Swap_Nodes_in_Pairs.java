import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class L0024_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null && cur.next != null) {
            ListNode after = cur.next;
            cur.next = after.next;
            after.next = cur;
            if(pre != null) pre.next = after;
            if(after.next == head) head = after;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}

