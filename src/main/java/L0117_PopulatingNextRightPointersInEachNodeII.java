/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * 给定一个二叉树：
 * 
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2019/02/15/117_sample.png)
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * - 树中的节点数在范围 [0, 6000] 内
 * - -100 <= Node.val <= 100
 * 
 * 进阶：
 * - 你只能使用常量级额外空间。
 * - 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class L0117_PopulatingNextRightPointersInEachNodeII {
    
    // 节点定义
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 使用常量空间的解法
     * 基本思路是：
     * 1. 利用已建立的 next 指针遍历每一层
     * 2. 同时为下一层建立 next 指针
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        // 当前层的第一个节点
        Node levelStart = root;
        
        while (levelStart != null) {
            // 下一层的虚拟头节点
            Node dummyNext = new Node(0);
            // 用于构建下一层 next 指针的指针
            Node current = dummyNext;
            
            // 遍历当前层的节点
            Node node = levelStart;
            while (node != null) {
                // 处理左子节点
                if (node.left != null) {
                    current.next = node.left;
                    current = current.next;
                }
                // 处理右子节点
                if (node.right != null) {
                    current.next = node.right;
                    current = current.next;
                }
                // 移动到当前层的下一个节点
                node = node.next;
            }
            
            // 移动到下一层的第一个节点
            levelStart = dummyNext.next;
        }
        
        return root;
    }

    public static void main(String[] args) {
        L0117_PopulatingNextRightPointersInEachNodeII solution = new L0117_PopulatingNextRightPointersInEachNodeII();
        
        // 测试用例 1：非完美二叉树
        Node root1 = solution.new Node(1);
        root1.left = solution.new Node(2);
        root1.right = solution.new Node(3);
        root1.left.left = solution.new Node(4);
        root1.left.right = solution.new Node(5);
        root1.right.right = solution.new Node(7);
        
        System.out.println("Test Case 1:");
        Node result1 = solution.connect(root1);
        printLevelOrder(result1);
        
        // 测试用例 2：空树
        System.out.println("\nTest Case 2:");
        Node result2 = solution.connect(null);
        printLevelOrder(result2);
        
        // 测试用例 3：只有左子树的二叉树
        Node root3 = solution.new Node(1);
        root3.left = solution.new Node(2);
        root3.left.left = solution.new Node(4);
        System.out.println("\nTest Case 3:");
        Node result3 = solution.connect(root3);
        printLevelOrder(result3);
    }
    
    // 用于打印测试结果的辅助方法
    private static void printLevelOrder(Node root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        // 使用已经建立的 next 指针进行层序遍历
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                sb.append(current.val).append(",");
                current = current.next;
            }
            sb.append("#,");
            
            // 找到下一层的第一个节点
            current = levelStart;
            levelStart = null;
            while (current != null) {
                if (current.left != null) {
                    levelStart = current.left;
                    break;
                }
                if (current.right != null) {
                    levelStart = current.right;
                    break;
                }
                current = current.next;
            }
        }
        
        // 删除最后一个逗号并添加右括号
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
} 