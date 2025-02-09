import java.util.*;

/**
 * https://leetcode.cn/problems/insertion-sort-list/
 * 
 * 给定单个链表的头节点 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头节点 。
 * 
 * 插入排序 算法的步骤:
 * 1. 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 2. 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 3. 重复直到所有输入数据插入完为止。
 * 
 * 示例 1：
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * 
 * 示例 2：
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 * 
 * 提示：
 * - 列表中的节点数在 [1, 5000]范围内
 * - -5000 <= Node.val <= 5000
 */
public class L0147_InsertionSortList {
    
    // 链表节点定义
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode insertionSortList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        
        // 创建哨兵节点，简化插入操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 已排序部分的最后一个节点
        ListNode lastSorted = head;
        // 当前待插入的节点
        ListNode curr = head.next;
        
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                // 如果当前节点大于已排序部分的最后一个节点
                // 说明它已经在正确的位置上
                lastSorted = lastSorted.next;
            } else {
                // 从头开始查找插入位置
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // 将当前节点插入到找到的位置
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            // 移动到下一个待插入的节点
            curr = lastSorted.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        L0147_InsertionSortList solution = new L0147_InsertionSortList();
        
        // 测试用例 1: [4,2,1,3]
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        
        System.out.println("测试用例 1:");
        System.out.print("排序前: ");
        printList(head1);
        ListNode sorted1 = solution.insertionSortList(head1);
        System.out.print("排序后: ");
        printList(sorted1);
        
        // 测试用例 2: [-1,5,3,4,0]
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        
        System.out.println("\n测试用例 2:");
        System.out.print("排序前: ");
        printList(head2);
        ListNode sorted2 = solution.insertionSortList(head2);
        System.out.print("排序后: ");
        printList(sorted2);
    }
    
    // 打印链表
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
} 