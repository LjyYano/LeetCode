import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class L0019_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个哑节点，处理删除头节点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 快慢指针初始都指向哑节点
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 快指针先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // 快慢指针一起走，直到快指针到达末尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 删除倒数第 n 个节点
        slow.next = slow.next.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        L0019_RemoveNthNodeFromEndOfList solution = new L0019_RemoveNthNodeFromEndOfList();

        // 测试用例 1：删除倒数第二个节点
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("Input: head = [1,2,3,4,5], n = 2");
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        System.out.print("Output: [");
        while (result1 != null) {
            System.out.print(result1.val);
            if (result1.next != null) {
                System.out.print(",");
            }
            result1 = result1.next;
        }
        System.out.println("]");
        // 预期输出：[1,2,3,5]

        // 测试用例 2：删除头节点
        ListNode head2 = new ListNode(1);
        System.out.println("\nInput: head = [1], n = 1");
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        System.out.print("Output: [");
        while (result2 != null) {
            System.out.print(result2.val);
            if (result2.next != null) {
                System.out.print(",");
            }
            result2 = result2.next;
        }
        System.out.println("]");
        // 预期输出：[]

        // 测试用例 3：删除尾节点
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        System.out.println("\nInput: head = [1,2], n = 1");
        ListNode result3 = solution.removeNthFromEnd(head3, 1);
        System.out.print("Output: [");
        while (result3 != null) {
            System.out.print(result3.val);
            if (result3.next != null) {
                System.out.print(",");
            }
            result3 = result3.next;
        }
        System.out.println("]");
        // 预期输出：[1]
    }
} 