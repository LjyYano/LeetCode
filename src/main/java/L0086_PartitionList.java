import common.ListNode;

/**
 * https://leetcode.cn/problems/partition-list/
 * 
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对顺序。
 * 
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 
 * 提示：
 * - 链表中节点的数目在范围 [0, 200] 内
 * - -100 <= Node.val <= 100
 * - -200 <= x <= 200
 */
public class L0086_PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        // 创建两个哑节点，分别作为小于 x 和大于等于 x 的链表的头部
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode large = largeDummy;
        
        // 遍历原链表
        while (head != null) {
            if (head.val < x) {
                // 将小于 x 的节点连接到 small 链表
                small.next = head;
                small = small.next;
            } else {
                // 将大于等于 x 的节点连接到 large 链表
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        
        // 将 large 链表连接到 small 链表的末尾
        small.next = largeDummy.next;
        // 将 large 链表的末尾置为 null
        large.next = null;
        
        return smallDummy.next;
    }

    public static void main(String[] args) {
        L0086_PartitionList solution = new L0086_PartitionList();

        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);

        System.out.println("测试用例 1：");
        System.out.print("原始链表：");
        printList(head1);
        ListNode result1 = solution.partition(head1, 3);
        System.out.print("分隔后的链表：");
        printList(result1);
        System.out.println();

        // 测试用例 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);

        System.out.println("测试用例 2：");
        System.out.print("原始链表：");
        printList(head2);
        ListNode result2 = solution.partition(head2, 2);
        System.out.print("分隔后的链表：");
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