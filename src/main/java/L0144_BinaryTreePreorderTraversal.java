import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * 
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg)
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 提示：
 * - 树中节点数目在范围 [0, 100] 内
 * - -100 <= Node.val <= 100
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class L0144_BinaryTreePreorderTraversal {
    
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
    }
    
    /**
     * 递归解法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }
    
    private void preorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 前序遍历：根节点 -> 左子树 -> 右子树
        result.add(node.val);
        preorderRecursive(node.left, result);
        preorderRecursive(node.right, result);
    }
    
    /**
     * 迭代解法
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            // 注意：因为栈是后进先出，所以先压入右子节点，再压入左子节点
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0144_BinaryTreePreorderTraversal solution = new L0144_BinaryTreePreorderTraversal();
        
        // 测试用例 1：[1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        
        System.out.println("测试用例 1:");
        System.out.println("递归解法输出: " + solution.preorderTraversal(root1));
        System.out.println("迭代解法输出: " + solution.preorderTraversalIterative(root1));
        System.out.println();
        
        // 测试用例 2：空树
        TreeNode root2 = null;
        System.out.println("测试用例 2:");
        System.out.println("递归解法输出: " + solution.preorderTraversal(root2));
        System.out.println("迭代解法输出: " + solution.preorderTraversalIterative(root2));
        System.out.println();
        
        // 测试用例 3：单节点树
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试用例 3:");
        System.out.println("递归解法输出: " + solution.preorderTraversal(root3));
        System.out.println("迭代解法输出: " + solution.preorderTraversalIterative(root3));
    }
} 