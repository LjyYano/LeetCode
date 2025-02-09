import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * 
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/08/28/pre1.jpg)
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
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
 * - 树中节点的数目在范围 [0, 100] 内
 * - -100 <= Node.val <= 100
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class L0145_BinaryTreePostorderTraversal {
    
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }
    
    private void postorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 后序遍历：左子树 -> 右子树 -> 根节点
        postorderRecursive(node.left, result);
        postorderRecursive(node.right, result);
        result.add(node.val);
    }
    
    /**
     * 迭代解法
     */
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        
        while (current != null || !stack.isEmpty()) {
            // 将当前节点及其所有左子节点入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // 查看栈顶节点
            current = stack.peek();
            
            // 如果右子节点为空或已经访问过，则访问当前节点
            if (current.right == null || current.right == lastVisited) {
                result.add(current.val);
                stack.pop();
                lastVisited = current;
                current = null;
            } else {
                // 否则遍历右子树
                current = current.right;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0145_BinaryTreePostorderTraversal solution = new L0145_BinaryTreePostorderTraversal();
        
        // 测试用例 1：[1,null,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        
        System.out.println("测试用例 1:");
        System.out.println("递归解法输出: " + solution.postorderTraversal(root1));
        System.out.println("迭代解法输出: " + solution.postorderTraversalIterative(root1));
        System.out.println();
        
        // 测试用例 2：空树
        TreeNode root2 = null;
        System.out.println("测试用例 2:");
        System.out.println("递归解法输出: " + solution.postorderTraversal(root2));
        System.out.println("迭代解法输出: " + solution.postorderTraversalIterative(root2));
        System.out.println();
        
        // 测试用例 3：单节点树
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试用例 3:");
        System.out.println("递归解法输出: " + solution.postorderTraversal(root3));
        System.out.println("迭代解法输出: " + solution.postorderTraversalIterative(root3));
    }
} 