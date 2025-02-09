import common.ListNode;

/**
 * https://leetcode.cn/problems/reorder-list/
 * 
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → L2 → ... → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
 * 
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * 
 * 提示：
 * - 链表的长度范围为 [1, 5 * 10⁴]
 * - 1 <= Node.val <= 1000
 */
public class L0143_ReorderList {
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // 1. 使用快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        // 断开前后两部分
        prev.next = null;
        
        // 2. 反转后半部分链表
        ListNode second = reverseList(slow);
        
        // 3. 合并两个链表
        ListNode first = head;
        while (first != null && second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            
            first.next = second;
            second.next = firstNext;
            
            first = firstNext;
            second = secondNext;
        }
    }
    
    // 反转链表的辅助方法
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        L0143_ReorderList solution = new L0143_ReorderList();
        
        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        
        System.out.println("测试用例 1:");
        System.out.print("输入: ");
        printList(head1);
        solution.reorderList(head1);
        System.out.print("输出: ");
        printList(head1);
        System.out.println();
        
        // 测试用例 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        
        System.out.println("测试用例 2:");
        System.out.print("输入: ");
        printList(head2);
        solution.reorderList(head2);
        System.out.print("输出: ");
        printList(head2);
    }
    
    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
} 