/**
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一个高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg)
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg)
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 
 * 提示：
 * - 树中的节点数在范围 [0, 5000] 内
 * - -10⁴ <= Node.val <= 10⁴
 */
public class L0110_BalancedBinaryTree {
    
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

    public boolean isBalanced(TreeNode root) {
        // 空树也是平衡二叉树
        if (root == null) {
            return true;
        }
        // 计算高度，如果返回 -1 表示不平衡
        return getHeight(root) != -1;
    }

    /**
     * 获取树的高度，如果不平衡返回 -1
     * 采用自底向上的递归，避免重复计算高度
     */
    private int getHeight(TreeNode node) {
        // 空节点高度为 0
        if (node == null) {
            return 0;
        }

        // 递归计算左子树高度
        int leftHeight = getHeight(node.left);
        // 如果左子树不平衡，直接返回 -1
        if (leftHeight == -1) {
            return -1;
        }

        // 递归计算右子树高度
        int rightHeight = getHeight(node.right);
        // 如果右子树不平衡，直接返回 -1
        if (rightHeight == -1) {
            return -1;
        }

        // 如果左右子树高度差大于 1，返回 -1 表示不平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        L0110_BalancedBinaryTree solution = new L0110_BalancedBinaryTree();

        // 测试用例 1：平衡二叉树
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例 1：");
        System.out.println("输入：[3,9,20,null,null,15,7]");
        System.out.println("输出：" + solution.isBalanced(root1));
        System.out.println();

        // 测试用例 2：不平衡二叉树
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println("测试用例 2：");
        System.out.println("输入：[1,2,2,3,3,null,null,4,4]");
        System.out.println("输出：" + solution.isBalanced(root2));
        System.out.println();

        // 测试用例 3：空树
        System.out.println("测试用例 3：");
        System.out.println("输入：[]");
        System.out.println("输出：" + solution.isBalanced(null));
    }
} 