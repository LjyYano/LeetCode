import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/add-two-numbers/
 * 
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class L0002_AddTwoNumbers {
    
    /**
     * 同时遍历两个链表，对应位置的数字相加，注意处理进位
     * 
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 相加后的结果链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个哑节点作为结果链表的头部
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 进位值
        int carry = 0;
        
        // 当 l1 或 l2 不为空，或者还有进位时，继续循环
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前位的值，如果节点为空则取 0
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            
            // 计算当前位的和与进位
            int sum = x + y + carry;
            carry = sum / 10;
            
            // 创建新节点存储当前位的值
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            // 移动到下一个节点
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试用例
        L0002_AddTwoNumbers solution = new L0002_AddTwoNumbers();
        
        // 测试用例 1: l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("测试用例 1:");
        System.out.println("输入: l1 = [2,4,3], l2 = [5,6,4]");
        System.out.print("输出: ");
        printList(solution.addTwoNumbers(l1, l2));
        
        // 测试用例 2: l1 = [0], l2 = [0]
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);

        System.out.println("\n测试用例 2:");
        System.out.println("输入: l1 = [0], l2 = [0]");
        System.out.print("输出: ");
        printList(solution.addTwoNumbers(l3, l4));
        
        // 测试用例 3: l1 = [9,9,9,9], l2 = [9,9,9]
        ListNode l5 = new ListNode(9);
        l5.next = new ListNode(9);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(9);

        ListNode l6 = new ListNode(9);
        l6.next = new ListNode(9);
        l6.next.next = new ListNode(9);

        System.out.println("\n测试用例 3:");
        System.out.println("输入: l1 = [9,9,9,9], l2 = [9,9,9]");
        System.out.print("输出: ");
        printList(solution.addTwoNumbers(l5, l6));
    }
    
    /**
     * 打印链表
     */
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