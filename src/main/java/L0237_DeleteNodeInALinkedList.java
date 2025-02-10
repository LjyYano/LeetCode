/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * 
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 
 * 给你一个需要删除的节点 node。你将 无法访问 第一个节点  head。
 * 
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * 
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * - 给定节点的值不应该存在于链表中
 * - 链表中的节点数应该减少 1
 * - node 的所有后继节点的值都应该往前移动一个位置
 * - 如果链表只有 2 个节点，你不需要删除给定的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/09/01/node1.jpg)
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/09/01/node2.jpg)
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 * 
 * 提示：
 * - 链表中节点的数目范围是 [2, 1000]
 * - -1000 <= Node.val <= 1000
 * - 链表中每个节点的值都是 唯一 的
 * - 需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点
 */
public class L0237_DeleteNodeInALinkedList {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    /**
     * 由于无法访问头节点，我们只能访问要删除的节点
     * 我们可以通过将下一个节点的值复制到当前节点，然后删除下一个节点来实现
     */
    public void deleteNode(ListNode node) {
        // 将下一个节点的值复制到当前节点
        node.val = node.next.val;
        // 删除下一个节点
        node.next = node.next.next;
    }
    
    public static void main(String[] args) {
        L0237_DeleteNodeInALinkedList solution = new L0237_DeleteNodeInALinkedList();
        
        // 构建示例 1 中的链表：4 -> 5 -> 1 -> 9
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);
        
        System.out.println("删除前的链表：");
        printList(head1);
        
        // 删除值为 5 的节点
        solution.deleteNode(head1.next);
        
        System.out.println("删除后的链表：");
        printList(head1);
        
        // 构建示例 2 中的链表：4 -> 5 -> 1 -> 9
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);
        
        System.out.println("\n删除前的链表：");
        printList(head2);
        
        // 删除值为 1 的节点
        solution.deleteNode(head2.next.next);
        
        System.out.println("删除后的链表：");
        printList(head2);
    }
    
    // 辅助方法：打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
} 