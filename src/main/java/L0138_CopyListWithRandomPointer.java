/**
 * https://leetcode.cn/problems/copy-list-with-random-pointer/
 * 
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点。
 * 
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * - val：一个表示 Node.val 的整数。
 * - random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 
 * 提示：
 * - 0 <= n <= 1000
 * - -10^4 <= Node.val <= 10^4
 * - Node.random 为 null 或指向链表中的节点。
 */

import java.util.HashMap;
import java.util.Map;

public class L0138_CopyListWithRandomPointer {
    
    // 节点定义
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        // 使用哈希表存储原节点到新节点的映射
        Map<Node, Node> visited = new HashMap<>();
        
        // 第一次遍历：创建所有新节点
        Node curr = head;
        while (curr != null) {
            visited.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        // 第二次遍历：设置新节点的 next 和 random 指针
        curr = head;
        while (curr != null) {
            visited.get(curr).next = visited.get(curr.next);
            visited.get(curr).random = visited.get(curr.random);
            curr = curr.next;
        }
        
        return visited.get(head);
    }

    // 辅助方法：创建测试用例
    private static Node createTestCase(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        // 创建所有节点
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i][0]);
        }
        
        // 设置 next 和 random 指针
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
            if (arr[i][1] != -1) {
                nodes[i].random = nodes[arr[i][1]];
            }
        }
        
        return nodes[0];
    }

    // 辅助方法：验证结果
    private static boolean verifyResult(Node original, Node copy) {
        Map<Node, Node> mapping = new HashMap<>();
        Node curr1 = original;
        Node curr2 = copy;
        
        // 验证节点值和构建映射
        while (curr1 != null && curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            mapping.put(curr1, curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        // 验证两个链表长度相同
        if (curr1 != null || curr2 != null) {
            return false;
        }
        
        // 验证 random 指针
        curr1 = original;
        while (curr1 != null) {
            Node originalRandom = curr1.random;
            Node copyRandom = mapping.get(curr1).random;
            
            if ((originalRandom == null && copyRandom != null) ||
                (originalRandom != null && copyRandom == null) ||
                (originalRandom != null && copyRandom != null && 
                 !mapping.get(originalRandom).equals(copyRandom))) {
                return false;
            }
            curr1 = curr1.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0138_CopyListWithRandomPointer solution = new L0138_CopyListWithRandomPointer();
        
        // 测试用例 1
        int[][] test1 = {{7,-1}, {13,0}, {11,4}, {10,2}, {1,0}};
        Node head1 = createTestCase(test1);
        Node copy1 = solution.copyRandomList(head1);
        System.out.println("Test case 1 result: " + verifyResult(head1, copy1));
        
        // 测试用例 2
        int[][] test2 = {{1,1}, {2,1}};
        Node head2 = createTestCase(test2);
        Node copy2 = solution.copyRandomList(head2);
        System.out.println("Test case 2 result: " + verifyResult(head2, copy2));
        
        // 测试用例 3
        int[][] test3 = {{3,-1}, {3,0}, {3,-1}};
        Node head3 = createTestCase(test3);
        Node copy3 = solution.copyRandomList(head3);
        System.out.println("Test case 3 result: " + verifyResult(head3, copy3));
    }
} 