/**
 * https://leetcode.cn/problems/symmetric-tree/
 * 
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg)
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg)
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 提示：
 * - 树中节点数目在范围 [1, 1000] 内
 * - -100 <= Node.val <= 100
 */
public class L0101_SymmetricTree {
    
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
    
    public boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，认为是对称的
        if (root == null) {
            return true;
        }
        // 判断左右子树是否对称
        return isMirror(root.left, root.right);
    }
    
    /**
     * 判断两个子树是否互为镜像
     * 两个子树互为镜像的条件：
     * 1. 它们的根节点值相等
     * 2. 每个树的左子树与另一个树的右子树镜像对称
     */
    private boolean isMirror(TreeNode left, TreeNode right) {
        // 如果两个节点都为空，说明对称
        if (left == null && right == null) {
            return true;
        }
        // 如果其中一个节点为空，说明不对称
        if (left == null || right == null) {
            return false;
        }
        // 如果两个节点的值不相等，说明不对称
        if (left.val != right.val) {
            return false;
        }
        // 递归判断：
        // left 的左子树和 right 的右子树是否镜像
        // left 的右子树和 right 的左子树是否镜像
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        L0101_SymmetricTree solution = new L0101_SymmetricTree();

        // 测试用例 1：对称的树
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = " + root1);
        System.out.println("输出：" + solution.isSymmetric(root1));
        System.out.println();

        // 测试用例 2：不对称的树
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = " + root2);
        System.out.println("输出：" + solution.isSymmetric(root2));
        System.out.println();

        // 测试用例 3：单个节点
        TreeNode root3 = new TreeNode(1);
        System.out.println("测试用例 3：");
        System.out.println("输入：root = " + root3);
        System.out.println("输出：" + solution.isSymmetric(root3));
    }
} 