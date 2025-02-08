import common.ListNode;

/**
 * 题目链接：https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class L0024_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        
        // 创建一个哑节点，简化头节点的处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        // 当剩余节点数大于等于 2 个时，继续交换
        while (curr.next != null && curr.next.next != null) {
            // 记录要交换的两个节点
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            // 执行交换操作
            first.next = second.next;
            second.next = first;
            curr.next = second;
            
            // 移动到下一组的前一个节点
            curr = first;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试用例
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        L0024_SwapNodesInPairs solution = new L0024_SwapNodesInPairs();
        ListNode result = solution.swapPairs(head);

        // 打印结果
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        // 预期输出：2 -> 1 -> 4 -> 3
        System.out.println();

        // 测试空链表
        result = solution.swapPairs(null);
        System.out.println(result == null ? "null" : result.val);
        // 预期输出：null

        // 测试单节点链表
        result = solution.swapPairs(new ListNode(1));
        System.out.println(result.val);
        // 预期输出：1
    }
} 