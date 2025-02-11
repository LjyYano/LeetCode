import java.util.*;

/**
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/description/
 * 
 * 你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 。
 * 这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子项，以此类推，
 * 生成多级数据结构。给定链表的头节点 head ，将链表 扁平化 ，以便所有节点都出现在单层双链表中。
 * 让 curr 是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的 curr 之后 和 curr.next 之前 。
 * 返回 扁平化列表的 head 。
 * 
 * 示例 1：
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 
 * 示例 2：
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class L0430_FlattenAMultilevelDoublyLinkedList {
    
    // 定义多级双向链表节点
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        // 使用栈来保存下一个节点
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr.child != null) {
                // 如果有下一个节点，将其压入栈中
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                
                // 将子节点设置为下一个节点
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            } else if (curr.next == null && !stack.isEmpty()) {
                // 如果当前节点没有下一个节点，且栈不为空
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
    }

    // 辅助方法：打印链表
    private static void printList(Node head) {
        List<Integer> result = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        L0430_FlattenAMultilevelDoublyLinkedList solution = new L0430_FlattenAMultilevelDoublyLinkedList();
        
        // 测试用例1
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.prev = head1;
        head1.next.next = new Node(3);
        head1.next.next.prev = head1.next;
        head1.next.next.next = new Node(4);
        head1.next.next.next.prev = head1.next.next;
        
        head1.child = new Node(7);
        head1.child.next = new Node(8);
        head1.child.next.prev = head1.child;
        head1.child.next.child = new Node(11);
        head1.child.next.child.next = new Node(12);
        head1.child.next.child.next.prev = head1.child.next.child;
        
        System.out.println("测试用例1：");
        System.out.println("扁平化前：");
        printList(head1);
        Node result1 = solution.flatten(head1);
        System.out.println("扁平化后：");
        printList(result1);
        
        // 测试用例2
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.prev = head2;
        head2.child = new Node(3);
        
        System.out.println("\n测试用例2：");
        System.out.println("扁平化前：");
        printList(head2);
        Node result2 = solution.flatten(head2);
        System.out.println("扁平化后：");
        printList(result2);
    }
} 