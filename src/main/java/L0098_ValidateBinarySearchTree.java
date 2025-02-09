/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * - 节点的左子树只包含 小于 当前节点的数。
 * - 节点的右子树只包含 大于 当前节点的数。
 * - 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg)
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg)
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 
 * 提示：
 * - 树中节点数目范围在[1, 10⁴] 内
 * - -2³¹ <= Node.val <= 2³¹ - 1
 */
public class L0098_ValidateBinarySearchTree {
    
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
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    /**
     * 递归验证二叉搜索树
     * 使用 long 类型避免整数溢出
     * 
     * @param node 当前节点
     * @param min 当前节点允许的最小值
     * @param max 当前节点允许的最大值
     * @return 是否是有效的二叉搜索树
     */
    private boolean isValidBST(TreeNode node, long min, long max) {
        // 空节点认为是有效的二叉搜索树
        if (node == null) {
            return true;
        }
        
        // 检查当前节点的值是否在允许的范围内
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        // 递归验证左右子树
        // 左子树的所有节点值必须小于当前节点值
        // 右子树的所有节点值必须大于当前节点值
        return isValidBST(node.left, min, node.val) && 
               isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        L0098_ValidateBinarySearchTree solution = new L0098_ValidateBinarySearchTree();

        // 测试用例 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = [2,1,3]");
        System.out.println("输出：" + solution.isValidBST(root1));
        System.out.println("预期：true");
        System.out.println();

        // 测试用例 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = [5,1,4,null,null,3,6]");
        System.out.println("输出：" + solution.isValidBST(root2));
        System.out.println("预期：false");
        System.out.println();

        // 测试用例 3：边界值测试
        TreeNode root3 = new TreeNode(Integer.MAX_VALUE);
        System.out.println("测试用例 3：");
        System.out.println("输入：root = [" + Integer.MAX_VALUE + "]");
        System.out.println("输出：" + solution.isValidBST(root3));
        System.out.println("预期：true");
    }
} 