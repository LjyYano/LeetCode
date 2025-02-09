import common.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 
 * 图示两个链表在节点 c1 开始相交：
 * A:          a1 → a2
 *                     ↘
 *                       c1 → c2 → c3
 *                     ↗            
 * B:     b1 → b2 → b3
 * 
 * 题目数据 保证 整个链式结构中不存在环。
 * 
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 
 * 示例 2：
 * 输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * 
 * 提示：
 * - listA 中节点数目为 m
 * - listB 中节点数目为 n
 * - 1 <= m, n <= 3 * 10⁴
 * - 1 <= Node.val <= 10⁵
 * - 0 <= skipA <= m
 * - 0 <= skipB <= n
 * - 如果 listA 和 listB 没有交点，intersectVal 为 0
 * - 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 */
public class L0160_IntersectionOfTwoLinkedLists {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果任一链表为空，则不可能相交
        if (headA == null || headB == null) {
            return null;
        }
        
        // 使用两个指针 pA 和 pB 分别遍历链表 A 和链表 B
        ListNode pA = headA;
        ListNode pB = headB;
        
        // 当 pA 和 pB 不相等时继续遍历
        while (pA != pB) {
            // 如果 pA 到达链表末尾，则将其重定向到链表 B 的头部
            // 否则移动到下一个节点
            pA = pA == null ? headB : pA.next;
            
            // 如果 pB 到达链表末尾，则将其重定向到链表 A 的头部
            // 否则移动到下一个节点
            pB = pB == null ? headA : pB.next;
        }
        
        // 返回相交节点（如果不相交则为 null）
        return pA;
    }

    public static void main(String[] args) {
        L0160_IntersectionOfTwoLinkedLists solution = new L0160_IntersectionOfTwoLinkedLists();
        
        // 创建测试用例
        ListNode commonPart = new ListNode(8);
        commonPart.next = new ListNode(4);
        commonPart.next.next = new ListNode(5);
        
        // 创建链表 A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = commonPart;
        
        // 创建链表 B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = commonPart;
        
        // 测试并打印结果
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        System.out.println("相交节点的值：" + (intersection != null ? intersection.val : "null"));
    }
} 