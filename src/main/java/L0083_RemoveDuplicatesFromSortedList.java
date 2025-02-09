/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 
 * 给定一个已排序的链表的头 head ，删除所有重复的元素，使每个元素只出现一次。返回已排序的链表。
 * 
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 
 * 提示：
 * - 链表中节点数目在范围 [0, 300] 内
 * - -100 <= Node.val <= 100
 * - 题目数据保证链表已经按升序排列
 */
public class L0083_RemoveDuplicatesFromSortedList {
    
    // 链表节点定义
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        // 处理空链表和只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        
        // 使用一个指针遍历链表
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            // 如果当前节点与下一个节点的值相同，跳过下一个节点
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // 如果不相同，移动到下一个节点
                curr = curr.next;
            }
        }
        
        return head;
    }

    // 辅助方法：创建链表
    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(",");
            }
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        L0083_RemoveDuplicatesFromSortedList solution = new L0083_RemoveDuplicatesFromSortedList();

        // 测试用例 1
        System.out.println("测试用例 1:");
        ListNode head1 = createList(new int[]{1, 1, 2});
        System.out.print("输入: ");
        printList(head1);
        ListNode result1 = solution.deleteDuplicates(head1);
        System.out.print("输出: ");
        printList(result1);
        System.out.println();

        // 测试用例 2
        System.out.println("测试用例 2:");
        ListNode head2 = createList(new int[]{1, 1, 2, 3, 3});
        System.out.print("输入: ");
        printList(head2);
        ListNode result2 = solution.deleteDuplicates(head2);
        System.out.print("输出: ");
        printList(result2);
        System.out.println();

        // 测试用例 3：空链表
        System.out.println("测试用例 3 (空链表):");
        ListNode head3 = null;
        System.out.println("输入: []");
        ListNode result3 = solution.deleteDuplicates(head3);
        System.out.print("输出: ");
        printList(result3);
    }
} 