import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 * 
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/03/12/paths-tree.jpg)
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * 
 * 提示：
 * - 树中节点的数目在范围 [1, 100] 内
 * - -100 <= Node.val <= 100
 */
public class L0257_BinaryTreePaths {
    
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        // 如果是叶子节点，直接将节点值转换为字符串并返回
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }
        
        // 递归获取左子树的所有路径
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        
        // 递归获取右子树的所有路径
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        return paths;
    }

    public static void main(String[] args) {
        L0257_BinaryTreePaths solution = new L0257_BinaryTreePaths();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        System.out.println("测试用例 1：");
        System.out.println("输入：[1,2,3,null,5]");
        System.out.println("输出：" + solution.binaryTreePaths(root1));
        
        // 测试用例 2
        TreeNode root2 = new TreeNode(1);
        System.out.println("\n测试用例 2：");
        System.out.println("输入：[1]");
        System.out.println("输出：" + solution.binaryTreePaths(root2));
    }
} 