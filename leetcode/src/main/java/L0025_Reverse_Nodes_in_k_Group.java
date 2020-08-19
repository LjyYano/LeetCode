import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class L0025_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preHead = dummy, tail = dummy, postTail, tmp;
        int count = 0;
        while (tail != null) {
            if (count == k) {
                count = 0;
                postTail = tail.next;
                tail.next = null;
                preHead.next = null;
                tail = head;               //reuse "tail"
                while (tail != null) {     //reverse head to original tail
                    tmp = tail.next;
                    tail.next = preHead.next;
                    preHead.next = tail;
                    tail = tmp;
                }
                head.next = postTail;
                preHead = head;
                tail = preHead;
                head = head.next;
            }
            tail = tail.next;
            count++;
        }
        return dummy.next;
    }
}