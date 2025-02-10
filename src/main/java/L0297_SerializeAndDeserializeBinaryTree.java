import java.util.*;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg)
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 提示：
 * - 树中结点数在范围 [0, 10⁴] 内
 * - -1000 <= Node.val <= 1000
 */
public class L0297_SerializeAndDeserializeBinaryTree {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(this, sb);
            return sb.toString();
        }

        private void toString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null");
                return;
            }
            sb.append(node.val);
            if (node.left != null || node.right != null) {
                sb.append(",");
                toString(node.left, sb);
                sb.append(",");
                toString(node.right, sb);
            }
        }
    }

    /**
     * 序列化二叉树
     * 使用前序遍历的方式，将二叉树序列化为字符串
     * 空节点使用 "null" 表示
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        // 前序遍历：根节点 -> 左子树 -> 右子树
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    /**
     * 反序列化二叉树
     * 将字符串反序列化为二叉树
     */
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String value = queue.poll();
        if (value == null || value.equals("null")) {
            return null;
        }
        // 创建当前节点
        TreeNode node = new TreeNode(Integer.parseInt(value));
        // 递归构建左右子树
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    public static void main(String[] args) {
        L0297_SerializeAndDeserializeBinaryTree codec = new L0297_SerializeAndDeserializeBinaryTree();

        // 测试用例 1：[1,2,3,null,null,4,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        String serialized1 = codec.serialize(root1);
        TreeNode deserialized1 = codec.deserialize(serialized1);
        System.out.println("Test Case 1:");
        System.out.println("Original: " + root1);
        System.out.println("Serialized: " + serialized1);
        System.out.println("Deserialized: " + deserialized1);
        System.out.println();

        // 测试用例 2：[]
        TreeNode root2 = null;
        String serialized2 = codec.serialize(root2);
        TreeNode deserialized2 = codec.deserialize(serialized2);
        System.out.println("Test Case 2:");
        System.out.println("Original: null");
        System.out.println("Serialized: " + serialized2);
        System.out.println("Deserialized: " + (deserialized2 == null ? "null" : deserialized2));
        System.out.println();

        // 测试用例 3：[1]
        TreeNode root3 = new TreeNode(1);
        String serialized3 = codec.serialize(root3);
        TreeNode deserialized3 = codec.deserialize(serialized3);
        System.out.println("Test Case 3:");
        System.out.println("Original: " + root3);
        System.out.println("Serialized: " + serialized3);
        System.out.println("Deserialized: " + deserialized3);
    }
} 