import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/merge-two-sorted-lists/
 * 
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class L0021_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个哑节点作为新链表的头部
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 当两个链表都不为空时，比较节点值并连接
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // 如果 list1 还有剩余节点，直接连接到末尾
        if (list1 != null) {
            current.next = list1;
        }
        
        // 如果 list2 还有剩余节点，直接连接到末尾
        if (list2 != null) {
            current.next = list2;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        L0021_MergeTwoSortedLists solution = new L0021_MergeTwoSortedLists();

        // 测试用例 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("Input: list1 = [1,2,4], list2 = [1,3,4]");
        ListNode result1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Output: [");
        while (result1 != null) {
            System.out.print(result1.val);
            if (result1.next != null) {
                System.out.print(",");
            }
            result1 = result1.next;
        }
        System.out.println("]");
        // 预期输出：[1,1,2,3,4,4]

        // 测试用例 2
        System.out.println("\nInput: list1 = [], list2 = []");
        ListNode result2 = solution.mergeTwoLists(null, null);
        System.out.print("Output: [");
        while (result2 != null) {
            System.out.print(result2.val);
            if (result2.next != null) {
                System.out.print(",");
            }
            result2 = result2.next;
        }
        System.out.println("]");
        // 预期输出：[]

        // 测试用例 3
        ListNode list3 = null;
        ListNode list4 = new ListNode(0);

        System.out.println("\nInput: list1 = [], list2 = [0]");
        ListNode result3 = solution.mergeTwoLists(list3, list4);
        System.out.print("Output: [");
        while (result3 != null) {
            System.out.print(result3.val);
            if (result3.next != null) {
                System.out.print(",");
            }
            result3 = result3.next;
        }
        System.out.println("]");
        // 预期输出：[0]
    }
} 