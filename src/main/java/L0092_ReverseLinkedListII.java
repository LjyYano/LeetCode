import common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 提示：
 * - 链表中节点数目为 n
 * - 1 <= n <= 500
 * - -500 <= Node.val <= 500
 * - 1 <= left <= right <= n
 */
public class L0092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果链表为空或者只有一个节点，或者 left 等于 right，直接返回
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // 创建一个虚拟头节点，方便处理 left = 1 的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // 找到要反转部分的前一个节点
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        // 开始反转
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        L0092_ReverseLinkedListII solution = new L0092_ReverseLinkedListII();

        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("输入：head = [1,2,3,4,5], left = 2, right = 4");
        System.out.println("输出：" + solution.reverseBetween(head1, 2, 4));
        System.out.println("预期：[1,4,3,2,5]");
        System.out.println();

        // 测试用例 2
        ListNode head2 = new ListNode(5);
        System.out.println("输入：head = [5], left = 1, right = 1");
        System.out.println("输出：" + solution.reverseBetween(head2, 1, 1));
        System.out.println("预期：[5]");
    }
} 