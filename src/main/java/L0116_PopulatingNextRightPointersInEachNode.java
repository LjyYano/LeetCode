/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * 
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * - 树中节点的数量在 [0, 2¹² - 1] 范围内
 * - -1000 <= node.val <= 1000
 * 
 * 进阶：
 * - 你只能使用常量级额外空间。
 * - 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class L0116_PopulatingNextRightPointersInEachNode {
    
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
     * 使用递归方法填充每个节点的 next 指针
     * 对于每个节点，我们需要：
     * 1. 将左子节点的 next 指向右子节点
     * 2. 将右子节点的 next 指向父节点的 next 的左子节点（如果父节点的 next 存在）
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        // 处理左子节点
        if (root.left != null) {
            // 左子节点的 next 指向右子节点
            root.left.next = root.right;
            
            // 右子节点的 next 指向父节点的 next 的左子节点
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        // 递归处理左右子树
        connect(root.left);
        connect(root.right);
        
        return root;
    }

    public static void main(String[] args) {
        L0116_PopulatingNextRightPointersInEachNode solution = new L0116_PopulatingNextRightPointersInEachNode();
        
        // 测试用例 1：完整的完美二叉树
        Node root1 = solution.new Node(1);
        root1.left = solution.new Node(2);
        root1.right = solution.new Node(3);
        root1.left.left = solution.new Node(4);
        root1.left.right = solution.new Node(5);
        root1.right.left = solution.new Node(6);
        root1.right.right = solution.new Node(7);
        
        System.out.println("Test Case 1:");
        Node result1 = solution.connect(root1);
        printLevelOrder(result1);
        
        // 测试用例 2：空树
        System.out.println("\nTest Case 2:");
        Node result2 = solution.connect(null);
        printLevelOrder(result2);
        
        // 测试用例 3：只有一个节点的树
        Node root3 = solution.new Node(1);
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
            levelStart = levelStart.left;
        }
        
        // 删除最后一个逗号并添加右括号
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
} 