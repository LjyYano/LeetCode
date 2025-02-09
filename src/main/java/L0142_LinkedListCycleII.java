import common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 * 不允许修改 链表。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 示例 3：
 * ![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * 
 * 提示：
 * - 链表中节点的数目范围在范围 [0, 10⁴] 内
 * - -10⁵ <= Node.val <= 10⁵
 * - pos 的值为 -1 或者链表中的一个有效索引
 * 
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */
public class L0142_LinkedListCycleII {
    
    public ListNode detectCycle(ListNode head) {
        // 如果链表为空或只有一个节点，不可能有环
        if (head == null || head.next == null) {
            return null;
        }
        
        // 使用快慢指针找到相遇点
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        // 如果没有环，返回 null
        if (!hasCycle) {
            return null;
        }
        
        // 将一个指针重新指向头节点，然后两个指针同速前进
        // 它们的相遇点就是环的入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        L0142_LinkedListCycleII solution = new L0142_LinkedListCycleII();
        
        // 测试用例 1：有环的链表，环的入口在第二个节点
        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;  // 创建环
        
        ListNode result1 = solution.detectCycle(head1);
        System.out.println("测试用例 1 (环的入口节点值): " + 
            (result1 != null ? result1.val : "null"));  // 预期输出：2
        
        // 测试用例 2：无环的链表
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        
        ListNode result2 = solution.detectCycle(head2);
        System.out.println("测试用例 2 (无环): " + 
            (result2 != null ? result2.val : "null"));  // 预期输出：null
        
        // 测试用例 3：单节点链表
        ListNode head3 = new ListNode(1);
        
        ListNode result3 = solution.detectCycle(head3);
        System.out.println("测试用例 3 (单节点): " + 
            (result3 != null ? result3.val : "null"));  // 预期输出：null
    }
} 