/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/tree.jpg)
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 
 * 示例 2：
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 
 * 提示：
 * - 1 <= inorder.length <= 3000
 * - postorder.length == inorder.length
 * - -3000 <= inorder[i], postorder[i] <= 3000
 * - inorder 和 postorder 都由 不同 的值组成
 * - postorder 中每一个值都在 inorder 中
 * - inorder 保证是树的中序遍历
 * - postorder 保证是树的后序遍历
 */
public class L0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    
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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    /**
     * 递归构建二叉树
     * 
     * @param inorder 中序遍历数组
     * @param inStart 中序遍历的起始位置
     * @param inEnd 中序遍历的结束位置
     * @param postorder 后序遍历数组
     * @param postStart 后序遍历的起始位置
     * @param postEnd 后序遍历的结束位置
     * @return 构建的二叉树根节点
     */
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                   int[] postorder, int postStart, int postEnd) {
        // 如果起始位置大于结束位置，说明没有节点需要处理
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // 后序遍历的最后一个节点是根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // 在中序遍历中找到根节点的位置
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        
        // 计算左子树的节点数
        int leftSubtreeSize = rootIndex - inStart;
        
        // 递归构建左子树和右子树
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1,
                                  postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd,
                                   postorder, postStart + leftSubtreeSize, postEnd - 1);
        
        return root;
    }

    public static void main(String[] args) {
        L0106_ConstructBinaryTreeFromInorderAndPostorderTraversal solution = 
            new L0106_ConstructBinaryTreeFromInorderAndPostorderTraversal();

        // 测试用例 1
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        System.out.println("测试用例 1：");
        System.out.println("输入：inorder = " + java.util.Arrays.toString(inorder1) + 
                         ", postorder = " + java.util.Arrays.toString(postorder1));
        TreeNode result1 = solution.buildTree(inorder1, postorder1);
        System.out.println("输出：" + result1);
        System.out.println();

        // 测试用例 2
        int[] inorder2 = {-1};
        int[] postorder2 = {-1};
        System.out.println("测试用例 2：");
        System.out.println("输入：inorder = " + java.util.Arrays.toString(inorder2) + 
                         ", postorder = " + java.util.Arrays.toString(postorder2));
        TreeNode result2 = solution.buildTree(inorder2, postorder2);
        System.out.println("输出：" + result2);
        System.out.println();

        // 测试用例 3：更复杂的树
        int[] inorder3 = {4, 2, 5, 1, 6, 3};
        int[] postorder3 = {4, 5, 2, 6, 3, 1};
        System.out.println("测试用例 3：");
        System.out.println("输入：inorder = " + java.util.Arrays.toString(inorder3) + 
                         ", postorder = " + java.util.Arrays.toString(postorder3));
        TreeNode result3 = solution.buildTree(inorder3, postorder3);
        System.out.println("输出：" + result3);
    }
} 