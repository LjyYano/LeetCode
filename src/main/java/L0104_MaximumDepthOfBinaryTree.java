/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * 
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *      /  \
 *     15   7
 * 返回它的最大深度 3 。
 * 
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 
 * 提示：
 * - 树中节点的数量在 [0, 10⁴] 范围内
 * - -100 <= Node.val <= 100
 */
public class L0104_MaximumDepthOfBinaryTree {
    
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(this, sb);
            return sb.toString();
        }

        private void toString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null");
                return;
            }
            sb.append(node.val);
            if (node.left != null || node.right != null) {
                sb.append(",");
                toString(node.left, sb);
                sb.append(",");
                toString(node.right, sb);
            }
        }
    }
    
    public int maxDepth(TreeNode root) {
        // 如果节点为空，深度为 0
        if (root == null) {
            return 0;
        }
        
        // 递归计算左右子树的最大深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // 返回左右子树中较大的深度加上当前节点（即加 1）
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        L0104_MaximumDepthOfBinaryTree solution = new L0104_MaximumDepthOfBinaryTree();

        // 测试用例 1：普通二叉树
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = " + root1);
        System.out.println("输出：" + solution.maxDepth(root1));
        System.out.println("预期：3");
        System.out.println();

        // 测试用例 2：单分支树
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = " + root2);
        System.out.println("输出：" + solution.maxDepth(root2));
        System.out.println("预期：2");
        System.out.println();

        // 测试用例 3：空树
        System.out.println("测试用例 3：");
        System.out.println("输入：root = null");
        System.out.println("输出：" + solution.maxDepth(null));
        System.out.println("预期：0");
    }
} 