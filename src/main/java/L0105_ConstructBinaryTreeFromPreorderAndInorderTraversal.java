/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/tree.jpg)
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 示例 2：
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 提示:
 * - 1 <= preorder.length <= 3000
 * - inorder.length == preorder.length
 * - -3000 <= preorder[i], inorder[i] <= 3000
 * - preorder 和 inorder 均 无重复 元素
 * - inorder 均出现在 preorder
 * - preorder 保证 为二叉树的前序遍历序列
 * - inorder 保证 为二叉树的中序遍历序列
 */
public class L0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    /**
     * 递归构建二叉树
     * 
     * @param preorder 前序遍历数组
     * @param preStart 前序遍历的起始位置
     * @param preEnd 前序遍历的结束位置
     * @param inorder 中序遍历数组
     * @param inStart 中序遍历的起始位置
     * @param inEnd 中序遍历的结束位置
     * @return 构建的二叉树根节点
     */
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                   int[] inorder, int inStart, int inEnd) {
        // 如果起始位置大于结束位置，说明没有节点需要处理
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // 前序遍历的第一个节点是根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // 在中序遍历中找到根节点的位置
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        
        // 计算左子树的节点数
        int leftSubtreeSize = rootIndex - inStart;
        
        // 递归构建左子树和右子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                                  inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                                   inorder, rootIndex + 1, inEnd);
        
        return root;
    }

    public static void main(String[] args) {
        L0105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = 
            new L0105_ConstructBinaryTreeFromPreorderAndInorderTraversal();

        // 测试用例 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        System.out.println("测试用例 1：");
        System.out.println("输入：preorder = " + java.util.Arrays.toString(preorder1) + 
                         ", inorder = " + java.util.Arrays.toString(inorder1));
        TreeNode result1 = solution.buildTree(preorder1, inorder1);
        System.out.println("输出：" + result1);
        System.out.println();

        // 测试用例 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        System.out.println("测试用例 2：");
        System.out.println("输入：preorder = " + java.util.Arrays.toString(preorder2) + 
                         ", inorder = " + java.util.Arrays.toString(inorder2));
        TreeNode result2 = solution.buildTree(preorder2, inorder2);
        System.out.println("输出：" + result2);
        System.out.println();

        // 测试用例 3：更复杂的树
        int[] preorder3 = {1, 2, 4, 5, 3, 6};
        int[] inorder3 = {4, 2, 5, 1, 6, 3};
        System.out.println("测试用例 3：");
        System.out.println("输入：preorder = " + java.util.Arrays.toString(preorder3) + 
                         ", inorder = " + java.util.Arrays.toString(inorder3));
        TreeNode result3 = solution.buildTree(preorder3, inorder3);
        System.out.println("输出：" + result3);
    }
} 