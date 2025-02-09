/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 * 
 * 题目描述:
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * - 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 
 * 叶节点 是指没有子节点的节点。
 * 
 * 示例 1：
 *     1
 *    / \
 *   2   3
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 
 * 示例 2：
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * 
 * 提示：
 * - 树中节点的数目在范围 [1, 1000] 内
 * - 0 <= Node.val <= 9
 * - 树的深度不超过 10
 */
public class L0129_SumRootToLeafNumbers {
    // 二叉树节点的定义
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

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    // 深度优先搜索
    private int dfs(TreeNode node, int currentSum) {
        // 如果节点为空，返回 0
        if (node == null) {
            return 0;
        }
        
        // 计算当前路径的数字
        currentSum = currentSum * 10 + node.val;
        
        // 如果是叶子节点，返回当前路径的数字
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // 递归处理左右子树，并返回它们的和
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    public static void main(String[] args) {
        L0129_SumRootToLeafNumbers solution = new L0129_SumRootToLeafNumbers();
        
        // 测试用例 1
        //     1
        //    / \
        //   2   3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("测试用例 1:");
        System.out.println("输入: [1,2,3]");
        System.out.println("输出: " + solution.sumNumbers(root1));
        System.out.println();
        
        // 测试用例 2
        //     4
        //    / \
        //   9   0
        //  / \
        // 5   1
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);
        System.out.println("测试用例 2:");
        System.out.println("输入: [4,9,0,5,1]");
        System.out.println("输出: " + solution.sumNumbers(root2));
    }
} 