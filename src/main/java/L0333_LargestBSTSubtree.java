/**
 * https://leetcode.cn/problems/largest-bst-subtree/
 * 
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 * 
 * 二叉搜索树（BST）中的所有节点都具备以下属性：
 * - 左子树的所有节点的值都小于当前节点的值
 * - 右子树的所有节点的值都大于当前节点的值
 * - 左子树和右子树都是二叉搜索树
 * 
 * 示例 1：
 * 输入：root = [10,5,15,1,8,null,7]
 * 输出：3
 * 解释：最大的 BST 子树是 [5,1,8]，节点数为 3。
 * 
 * 示例 2：
 * 输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 * 输出：2
 * 
 * 提示：
 * 树上节点数目的范围是 [0, 10⁴]
 * -10⁴ <= Node.val <= 10⁴
 */

import common.TreeNode;

public class L0333_LargestBSTSubtree {
    
    /**
     * 用于存储子树信息的类
     */
    private static class SubtreeInfo {
        int size;      // 子树大小
        int min;       // 子树中的最小值
        int max;       // 子树中的最大值
        boolean isBST; // 是否是 BST
        
        SubtreeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    /**
     * 查找最大 BST 子树
     * 时间复杂度：O(n)，其中 n 是树中节点的数量
     * 空间复杂度：O(h)，其中 h 是树的高度，用于递归调用栈
     */
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).size;
    }
    
    /**
     * 深度优先搜索，自底向上处理每个节点
     */
    private SubtreeInfo dfs(TreeNode node) {
        // 空节点是一个有效的 BST
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        
        // 递归处理左右子树
        SubtreeInfo left = dfs(node.left);
        SubtreeInfo right = dfs(node.right);
        
        // 当前节点构成 BST 的条件：
        // 1. 左右子树都是 BST
        // 2. 当前节点值大于左子树最大值
        // 3. 当前节点值小于右子树最小值
        if (left.isBST && right.isBST && 
            node.val > left.max && node.val < right.min) {
            // 当前子树是一个有效的 BST
            return new SubtreeInfo(
                left.size + right.size + 1,
                Math.min(node.val, left.min),
                Math.max(node.val, right.max),
                true
            );
        }
        
        // 当前子树不是 BST，返回较大的子树大小
        return new SubtreeInfo(
            Math.max(left.size, right.size),
            0,  // min 和 max 的值不重要，因为不是 BST
            0,
            false
        );
    }

    public static void main(String[] args) {
        L0333_LargestBSTSubtree solution = new L0333_LargestBSTSubtree();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(8);
        root1.right.right = new TreeNode(7);
        
        System.out.println("测试用例 1：");
        System.out.println("输入：[10,5,15,1,8,null,7]");
        System.out.println("输出：" + solution.largestBSTSubtree(root1));
        System.out.println("预期输出：3");
        System.out.println();
        
        // 测试用例 2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(5);
        root2.left.left.left = new TreeNode(2);
        root2.left.left.left.left = new TreeNode(1);
        
        System.out.println("测试用例 2：");
        System.out.println("输入：[4,2,7,2,3,5,null,2,null,null,null,null,null,1]");
        System.out.println("输出：" + solution.largestBSTSubtree(root2));
        System.out.println("预期输出：2");
    }
} 