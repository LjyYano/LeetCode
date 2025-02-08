import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class L0025_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果链表为空或 k=1，直接返回
        if (head == null || k == 1) {
            return head;
        }

        // 创建哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        // 计算链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        
        // 对每组进行翻转
        for (int i = 0; i < length / k; i++) {
            // 翻转当前组的 k 个节点
            for (int j = 1; j < k; j++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            // 移动到下一组
            prev = curr;
            curr = curr.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试用例
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        L0025_ReverseNodesInKGroup solution = new L0025_ReverseNodesInKGroup();
        
        // 测试 k=2 的情况
        ListNode result = solution.reverseKGroup(head, 2);
        System.out.print("k=2: ");
        printList(result);  // 预期输出：2 -> 1 -> 4 -> 3 -> 5

        // 重新创建测试用例
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 测试 k=3 的情况
        result = solution.reverseKGroup(head, 3);
        System.out.print("k=3: ");
        printList(result);  // 预期输出：3 -> 2 -> 1 -> 4 -> 5

        // 测试空链表
        result = solution.reverseKGroup(null, 2);
        System.out.print("空链表: ");
        printList(result);  // 预期输出：null

        // 测试 k=1 的情况
        head = new ListNode(1);
        head.next = new ListNode(2);
        result = solution.reverseKGroup(head, 1);
        System.out.print("k=1: ");
        printList(result);  // 预期输出：1 -> 2
    }

    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
} 