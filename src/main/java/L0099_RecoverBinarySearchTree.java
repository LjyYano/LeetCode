/**
 * https://leetcode.cn/problems/recover-binary-search-tree/
 * 
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/10/28/recover1.jpg)
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2020/10/28/recover2.jpg)
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * 
 * 提示：
 * - 树上节点的数目在范围 [2, 1000] 内
 * - -2³¹ <= Node.val <= 2³¹ - 1
 */
public class L0099_RecoverBinarySearchTree {
    
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
    
    // 记录需要交换的两个节点
    private TreeNode first = null;
    private TreeNode second = null;
    // 记录前一个节点
    private TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        // 中序遍历找到需要交换的节点
        inorder(root);
        
        // 交换两个节点的值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    /**
     * 中序遍历二叉树
     * 在遍历过程中找到需要交换的两个节点
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // 遍历左子树
        inorder(root.left);
        
        // 处理当前节点
        // 如果前一个节点的值大于当前节点的值，说明找到了一个错误的位置
        if (prev != null && prev.val > root.val) {
            // 第一个错误节点是第一次找到的较大的节点
            if (first == null) {
                first = prev;
            }
            // 第二个错误节点是最后一次找到的较小的节点
            second = root;
        }
        // 更新前一个节点
        prev = root;
        
        // 遍历右子树
        inorder(root.right);
    }

    public static void main(String[] args) {
        L0099_RecoverBinarySearchTree solution = new L0099_RecoverBinarySearchTree();

        // 测试用例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = " + root1);
        solution.recoverTree(root1);
        System.out.println("输出：" + root1);
        System.out.println();

        // 重置解决方案的状态变量
        solution.first = null;
        solution.second = null;
        solution.prev = null;

        // 测试用例 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = " + root2);
        solution.recoverTree(root2);
        System.out.println("输出：" + root2);
    }
} 