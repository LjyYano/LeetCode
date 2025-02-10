/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 
 * 题目描述:
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 提示：
 * - 链表中节点数目在范围[1, 10^5] 内
 * - 0 <= Node.val <= 9
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class L0234_PalindromeLinkedList {
    /**
     * 解法：快慢指针 + 反转链表
     * 时间复杂度 O(n)，空间复杂度 O(1)
     * 
     * 思路：
     * 1. 使用快慢指针找到链表中点
     * 2. 反转后半部分链表
     * 3. 比较前半部分和反转后的后半部分是否相同
     * 4. 恢复链表（可选）
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // 1. 使用快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. 反转后半部分链表
        ListNode secondHalf = reverseList(slow.next);
        
        // 3. 比较前半部分和反转后的后半部分
        ListNode firstHalf = head;
        ListNode secondHalfCopy = secondHalf; // 保存反转后的后半部分的头节点，用于后续恢复
        boolean isPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // 4. 恢复链表（可选）
        slow.next = reverseList(secondHalfCopy);
        
        return isPalindrome;
    }
    
    /**
     * 反转链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
} 