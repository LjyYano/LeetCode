import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * 
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg)
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * - 树中节点数目范围在 [0, 100] 内
 * - -100 <= Node.val <= 100
 */
public class L0226_InvertBinaryTree {
    
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
     * 递归解法
     * 对于每个节点，交换其左右子树
     */
    public TreeNode invertTree(TreeNode root) {
        // 如果根节点为空，直接返回
        if (root == null) {
            return null;
        }
        
        // 递归翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // 交换左右子树
        root.left = right;
        root.right = left;
        
        return root;
    }
    
    /**
     * 迭代解法
     * 使用队列进行层序遍历，对每个节点交换其左右子树
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            // 交换左右子树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            // 将左右子节点加入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return root;
    }

    public static void main(String[] args) {
        L0226_InvertBinaryTree solution = new L0226_InvertBinaryTree();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        System.out.println("原始树：" + root1);
        TreeNode inverted1 = solution.invertTree(root1);
        System.out.println("翻转后：" + inverted1);
        
        // 测试用例 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println("\n原始树：" + root2);
        TreeNode inverted2 = solution.invertTreeIterative(root2);
        System.out.println("翻转后：" + inverted2);
        
        // 测试用例 3
        TreeNode root3 = null;
        System.out.println("\n原始树：" + root3);
        TreeNode inverted3 = solution.invertTree(root3);
        System.out.println("翻转后：" + inverted3);
    }
} 