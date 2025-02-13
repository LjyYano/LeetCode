/**
 * https://leetcode.cn/problems/sum-of-left-leaves/description/
 * 
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * 
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24 
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 */
public class L0404_SumOfLeftLeaves {

    // 定义二叉树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        // 如果根节点为空，返回 0
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        // 如果左子节点存在且是叶子节点，加上其值
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        
        // 递归处理左右子树
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        L0404_SumOfLeftLeaves solution = new L0404_SumOfLeftLeaves();
        
        // 测试用例1：[3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例1结果：" + solution.sumOfLeftLeaves(root1));
        
        // 测试用例2：[1]
        TreeNode root2 = new TreeNode(1);
        System.out.println("测试用例2结果：" + solution.sumOfLeftLeaves(root2));
    }
} 