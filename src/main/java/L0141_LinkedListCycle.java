import common.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 示例 3：
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 
 * 提示：
 * - 链表中节点的数目范围是 [0, 10⁴]
 * - -10⁵ <= Node.val <= 10⁵
 * - pos 为 -1 或者链表中的一个 有效索引 。
 * 
 * 进阶：你能用 O(1) 内存解决此问题吗？
 */
public class L0141_LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        // 如果链表为空或只有一个节点，不可能有环
        if (head == null || head.next == null) {
            return false;
        }
        
        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        
        // 快指针每次移动两步，慢指针每次移动一步
        // 如果有环，快慢指针最终会相遇
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // 如果快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        
        // 如果快指针到达链表末尾，说明没有环
        return false;
    }

    public static void main(String[] args) {
        // 创建测试用例 1：有环的链表
        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;  // 创建环

        // 创建测试用例 2：无环的链表
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        L0141_LinkedListCycle solution = new L0141_LinkedListCycle();
        
        // 测试用例 1
        System.out.println("Test case 1 (has cycle): " + solution.hasCycle(head1));  // 预期输出：true
        
        // 测试用例 2
        System.out.println("Test case 2 (no cycle): " + solution.hasCycle(head2));   // 预期输出：false
    }
} 