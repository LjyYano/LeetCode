import java.util.PriorityQueue;
import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/merge-k-sorted-lists/
 * 
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class L0023_MergeKSortedLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // 创建一个最小堆，按节点值排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 将所有链表的头节点加入堆中
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        // 创建哑节点作为结果链表的头部
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // 不断从堆中取出最小的节点，并将其下一个节点加入堆中
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        L0023_MergeKSortedLists solution = new L0023_MergeKSortedLists();
        
        // 测试用例 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        
        ListNode[] lists1 = {list1, list2, list3};
        System.out.println("测试用例 1 的结果：");
        printList(solution.mergeKLists(lists1));
        // 预期输出：1->1->2->3->4->4->5->6
        
        // 测试用例 2
        System.out.println("\n测试用例 2 的结果：");
        printList(solution.mergeKLists(new ListNode[]{}));
        // 预期输出：null
        
        // 测试用例 3
        System.out.println("\n测试用例 3 的结果：");
        printList(solution.mergeKLists(new ListNode[]{null}));
        // 预期输出：null
    }
    
    // 打印链表的辅助方法
    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print("->");
            }
            curr = curr.next;
        }
        System.out.println();
    }
} 