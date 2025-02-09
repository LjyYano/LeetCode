import common.TreeNode;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg)
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 
 * 提示：
 * - 树中节点数的范围在 [0, 10⁵] 内
 * - -1000 <= Node.val <= 1000
 */
public class L0111_MinimumDepthOfBinaryTree {
    
    public int minDepth(TreeNode root) {
        // 如果根节点为空，深度为 0
        if (root == null) {
            return 0;
        }
        
        // 如果是叶子节点，深度为 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // 如果只有左子树
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // 如果只有右子树
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // 如果左右子树都存在，返回较小的深度加 1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        L0111_MinimumDepthOfBinaryTree solution = new L0111_MinimumDepthOfBinaryTree();

        // 测试用例 1：[3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例 1：输入 [3,9,20,null,null,15,7]，输出 " + solution.minDepth(root1));

        // 测试用例 2：[2,null,3,null,4,null,5,null,6]
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println("测试用例 2：输入 [2,null,3,null,4,null,5,null,6]，输出 " + solution.minDepth(root2));

        // 测试用例 3：空树
        TreeNode root3 = null;
        System.out.println("测试用例 3：输入 []，输出 " + solution.minDepth(root3));
    }
} 