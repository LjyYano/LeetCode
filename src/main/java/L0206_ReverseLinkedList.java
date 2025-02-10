import common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 
 * 提示：
 * - 链表中节点的数目范围是 [0, 5000]
 * - -5000 <= Node.val <= 5000
 */
public class L0206_ReverseLinkedList {
    
    /**
     * 迭代方法反转链表
     * 使用三个指针：prev、curr、next
     * 每次迭代将 curr 的 next 指向 prev
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            // 保存下一个节点
            ListNode next = curr.next;
            // 反转当前节点的指针
            curr.next = prev;
            // 移动指针
            prev = curr;
            curr = next;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        L0206_ReverseLinkedList solution = new L0206_ReverseLinkedList();
        
        // 测试用例 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println("Test case 1:");
        System.out.println("Input: [1,2,3,4,5]");
        ListNode result1 = solution.reverseList(head1);
        System.out.print("Output: [");
        while (result1 != null) {
            System.out.print(result1.val);
            if (result1.next != null) {
                System.out.print(",");
            }
            result1 = result1.next;
        }
        System.out.println("]");
        System.out.println();
        
        // 测试用例 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Test case 2:");
        System.out.println("Input: [1,2]");
        ListNode result2 = solution.reverseList(head2);
        System.out.print("Output: [");
        while (result2 != null) {
            System.out.print(result2.val);
            if (result2.next != null) {
                System.out.print(",");
            }
            result2 = result2.next;
        }
        System.out.println("]");
        System.out.println();
    }
} 