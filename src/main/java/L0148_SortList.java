import common.ListNode;

/**
 * https://leetcode.cn/problems/sort-list/
 * 
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表。
 * 要求：在 O(n log n) 时间复杂度和常数级空间复杂度下解决此问题。
 * 
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 
 * 提示：
 * - 链表中节点的数目在范围 [0, 5 * 10⁴] 内
 * - -10⁵ <= Node.val <= 10⁵
 */
public class L0148_SortList {
    
    public ListNode sortList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        
        // 使用快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 分割链表
        ListNode mid = slow.next;
        slow.next = null;
        
        // 递归排序两个子链表
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        // 合并两个有序链表
        return merge(left, right);
    }
    
    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
} 