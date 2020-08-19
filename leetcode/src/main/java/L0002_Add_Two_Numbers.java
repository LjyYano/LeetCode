import common.ListNode;
import common.Node;

// https://leetcode-cn.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class L0002_Add_Two_Numbers {

    /**
     * auto generate, don't delete start
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * end
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode rt = new ListNode(0);
        ListNode head = rt;

        while (l1 != null || l2 != null) {

            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int carry = (rt.val + v1 + v2) / 10;
            rt.val = (rt.val + v1 + v2) % 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 != null || l2 != null || carry != 0) {
                rt.next = new ListNode(carry);
                rt = rt.next;
            }
        }

        return head;
    }
}
