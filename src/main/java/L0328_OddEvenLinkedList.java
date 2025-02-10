import common.ListNode;

/**
 * https://leetcode.cn/problems/odd-even-linked-list/
 * 
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,3,5,2,4]
 * 
 * 示例 2：
 * 输入：head = [2,1,3,5,6,4,7]
 * 输出：[2,3,6,7,1,5,4]
 * 
 * 提示：
 * - n == 链表中的节点数
 * - 0 <= n <= 10⁴
 * - -10⁶ <= Node.val <= 10⁶
 */
public class L0328_OddEvenLinkedList {
    
    /**
     * 将链表分成奇数位置节点和偶数位置节点，然后重新连接
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        // 处理空链表和只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        
        // odd 指向奇数位置节点，even 指向偶数位置节点
        ListNode odd = head;
        ListNode even = head.next;
        // 保存偶数链表的头节点，用于最后连接
        ListNode evenHead = even;
        
        // 当 even 和 even.next 都不为空时继续遍历
        while (even != null && even.next != null) {
            // 更新奇数节点的 next
            odd.next = even.next;
            odd = odd.next;
            // 更新偶数节点的 next
            even.next = odd.next;
            even = even.next;
        }
        
        // 将奇数链表的最后一个节点指向偶数链表的头节点
        odd.next = evenHead;
        
        return head;
    }

    public static void main(String[] args) {
        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        
        L0328_OddEvenLinkedList solution = new L0328_OddEvenLinkedList();
        ListNode result1 = solution.oddEvenList(head1);
        // 输出：1->3->5->2->4
        printList(result1);
        
        // 测试用例 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        
        ListNode result2 = solution.oddEvenList(head2);
        // 输出：2->3->6->7->1->5->4
        printList(result2);
    }
    
    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
} 