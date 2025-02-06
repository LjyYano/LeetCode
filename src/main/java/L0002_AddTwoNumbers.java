import common.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class L0002_AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个哑节点作为结果链表的头部
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 进位值
        int carry = 0;
        
        // 当 l1 或 l2 不为空，或者还有进位时，继续循环
        while (l1 != null || l2 != null || carry != 0) {
            // 获取当前位的值，如果节点为空则取0
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        L0002_AddTwoNumbers solution = new L0002_AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        // 预期输出：7 -> 0 -> 8
    }
} 