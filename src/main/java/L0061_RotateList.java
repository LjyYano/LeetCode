/*
 * https://leetcode.cn/problems/rotate-list/
 * 
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10⁹
 */

import common.ListNode;

public class L0061_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        // 如果链表为空或只有一个节点，或者 k = 0，直接返回
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度，同时找到最后一个节点
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        // 计算实际需要旋转的步数
        k = k % length;
        // 如果 k = 0，说明旋转后和原链表一样，直接返回
        if (k == 0) {
            return head;
        }

        // 找到新的尾节点位置：倒数第 k+1 个节点
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // 旋转链表
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        L0061_RotateList solution = new L0061_RotateList();

        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("测试用例 1：");
        System.out.print("原始链表：");
        printList(head1);
        ListNode result1 = solution.rotateRight(head1, 2);
        System.out.print("旋转后的链表：");
        printList(result1);
        System.out.println();

        // 测试用例 2
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        System.out.println("测试用例 2：");
        System.out.print("原始链表：");
        printList(head2);
        ListNode result2 = solution.rotateRight(head2, 4);
        System.out.print("旋转后的链表：");
        printList(result2);
    }

    // 打印链表
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