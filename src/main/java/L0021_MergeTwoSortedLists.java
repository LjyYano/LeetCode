import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/merge-two-sorted-lists/
 * 
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class L0021_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个哑节点作为合并后链表的头部
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        // 当两个链表都不为空时，比较节点值并合并
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        // 处理剩余的节点
        curr.next = list1 != null ? list1 : list2;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试用例
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        L0021_MergeTwoSortedLists solution = new L0021_MergeTwoSortedLists();
        ListNode result = solution.mergeTwoLists(list1, list2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        // 预期输出：1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
} 