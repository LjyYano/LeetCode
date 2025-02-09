/**
 * https://leetcode.cn/problems/same-tree/
 * 
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 
 * 如果两棵树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg)
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg)
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 
 * 示例 3：
 * ![img](https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg)
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 
 * 提示：
 * - 两棵树上的节点数目都在范围 [0, 100] 内
 * - -10⁴ <= Node.val <= 10⁴
 */
public class L0100_SameTree {
    
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
    
    /**
     * 判断两棵二叉树是否相同
     * 使用递归的方式，同时遍历两棵树的对应节点进行比较
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个节点都为空，说明相同
        if (p == null && q == null) {
            return true;
        }
        // 如果其中一个节点为空，说明不相同
        if (p == null || q == null) {
            return false;
        }
        // 如果两个节点的值不相等，说明不相同
        if (p.val != q.val) {
            return false;
        }
        // 递归比较左右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        L0100_SameTree solution = new L0100_SameTree();

        // 测试用例 1：相同的树
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);
        System.out.println("测试用例 1：");
        System.out.println("输入：p = " + p1 + ", q = " + q1);
        System.out.println("输出：" + solution.isSameTree(p1, q1));
        System.out.println();

        // 测试用例 2：不同的树
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);
        System.out.println("测试用例 2：");
        System.out.println("输入：p = " + p2 + ", q = " + q2);
        System.out.println("输出：" + solution.isSameTree(p2, q2));
        System.out.println();

        // 测试用例 3：不同的树
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);
        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);
        System.out.println("测试用例 3：");
        System.out.println("输入：p = " + p3 + ", q = " + q3);
        System.out.println("输出：" + solution.isSameTree(p3, q3));
    }
} 