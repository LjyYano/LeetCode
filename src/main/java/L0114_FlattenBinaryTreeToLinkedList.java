import common.TreeNode;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * 
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * - 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * - 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg)
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 提示：
 * - 树中结点数在范围 [0, 2000] 内
 * - -100 <= Node.val <= 100
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class L0114_FlattenBinaryTreeToLinkedList {
    
    /**
     * 将二叉树展开为单链表
     * 使用前序遍历的方式，同时在遍历过程中修改树的结构
     */
    public void flatten(TreeNode root) {
        // 如果根节点为空，直接返回
        if (root == null) {
            return;
        }
        
        // 保存左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // 将左子树置为 null
        root.left = null;
        
        // 递归展开左子树
        flatten(left);
        // 递归展开右子树
        flatten(right);
        
        // 将展开后的左子树接到根节点的右边
        root.right = left;
        
        // 找到当前链表的末尾
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // 将展开后的右子树接到末尾
        current.right = right;
    }

    public static void main(String[] args) {
        L0114_FlattenBinaryTreeToLinkedList solution = new L0114_FlattenBinaryTreeToLinkedList();

        // 测试用例 1：[1,2,5,3,4,null,6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        System.out.println("测试用例 1：");
        System.out.println("输入：" + root1);
        solution.flatten(root1);
        System.out.println("输出：" + root1);
        System.out.println();

        // 测试用例 2：空树
        TreeNode root2 = null;
        System.out.println("测试用例 2：");
        System.out.println("输入：null");
        solution.flatten(root2);
        System.out.println("输出：null");
        System.out.println();

        // 测试用例 3：单个节点
        TreeNode root3 = new TreeNode(0);
        System.out.println("测试用例 3：");
        System.out.println("输入：" + root3);
        solution.flatten(root3);
        System.out.println("输出：" + root3);
    }
} 