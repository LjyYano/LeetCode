import common.TreeNode;

/**
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * 
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 * 
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * 
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * 
 * 提示：
 * - 树中节点的数目范围是[0, 5 * 10^4]
 * - 0 <= Node.val <= 5 * 10^4
 * - 题目数据保证输入的树是 完全二叉树
 * 
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class L0222_CountCompleteTreeNodes {
    
    /**
     * 利用完全二叉树的特性，结合二分查找来统计节点数
     * 时间复杂度：O(log^2 n)
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // 计算左子树的高度
        int leftHeight = getLeftHeight(root);
        // 计算右子树的高度
        int rightHeight = getRightHeight(root);
        
        // 如果左右子树高度相同，说明左子树是满二叉树
        if (leftHeight == rightHeight) {
            // 节点数为 2^h - 1
            return (1 << leftHeight) - 1;
        }
        
        // 否则递归统计左右子树的节点数
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    /**
     * 获取树的左边界高度（从 1 开始计数）
     */
    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    
    /**
     * 获取树的右边界高度（从 1 开始计数）
     */
    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        L0222_CountCompleteTreeNodes solution = new L0222_CountCompleteTreeNodes();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = [1,2,3,4,5,6]");
        System.out.println("输出：" + solution.countNodes(root1));  // 预期输出：6
        
        // 测试用例 2
        System.out.println("\n测试用例 2：");
        System.out.println("输入：root = []");
        System.out.println("输出：" + solution.countNodes(null));  // 预期输出：0
        
        // 测试用例 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("\n测试用例 3：");
        System.out.println("输入：root = [1]");
        System.out.println("输出：" + solution.countNodes(root3));  // 预期输出：1
    }
} 