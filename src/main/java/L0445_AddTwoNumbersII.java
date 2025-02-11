import common.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 * 
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 示例 1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 
 * 示例 2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 
 * 示例 3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 提示：
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * 
 * 进阶：如果输入链表不能翻转该如何解决？
 */
public class L0445_AddTwoNumbersII {

    // 使用栈来解决，不需要翻转链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建两个栈，分别存储两个链表的数字
        java.util.Stack<Integer> stack1 = new java.util.Stack<>();
        java.util.Stack<Integer> stack2 = new java.util.Stack<>();

        // 将第一个链表的数字压入栈中
        ListNode current = l1;
        while (current != null) {
            stack1.push(current.val);
            current = current.next;
        }

        // 将第二个链表的数字压入栈中
        current = l2;
        while (current != null) {
            stack2.push(current.val);
            current = current.next;
        }

        // 进位
        int carry = 0;
        // 结果链表的头节点
        ListNode head = null;

        // 只要还有数字未处理，就继续循环
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            // 取出栈顶元素并相加
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            // 计算进位和当前位的值
            carry = sum / 10;
            sum = sum % 10;

            // 创建新节点并插入到结果链表的头部
            ListNode newNode = new ListNode(sum);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        L0445_AddTwoNumbersII solution = new L0445_AddTwoNumbersII();

        // 测试用例 1
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("测试用例 1 结果：");
        printList(result); // 预期输出：7 8 0 7

        // 测试用例 2
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        result = solution.addTwoNumbers(l1, l2);
        System.out.print("测试用例 2 结果：");
        printList(result); // 预期输出：8 0 7

        // 测试用例 3
        l1 = new ListNode(0);
        l2 = new ListNode(0);

        result = solution.addTwoNumbers(l1, l2);
        System.out.print("测试用例 3 结果：");
        printList(result); // 预期输出：0
    }

    // 打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
} 