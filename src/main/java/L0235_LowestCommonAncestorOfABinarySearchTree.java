/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为："对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。"
 * 
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * ![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/binarysearchtree_improved.png)
 * 
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6 
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 说明:
 * - 所有节点的值都是唯一的。
 * - p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class L0235_LowestCommonAncestorOfABinarySearchTree {
    
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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为空，或者 p、q 中有一个是根节点，则根节点为最近公共祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // 利用二叉搜索树的特性，如果 p、q 的值都小于根节点，则最近公共祖先在左子树
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // 如果 p、q 的值都大于根节点，则最近公共祖先在右子树
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // 如果一个在左一个在右，则当前节点就是最近公共祖先
        return root;
    }
    
    public static void main(String[] args) {
        L0235_LowestCommonAncestorOfABinarySearchTree solution = new L0235_LowestCommonAncestorOfABinarySearchTree();
        
        // 构建示例中的二叉搜索树
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        
        // 测试用例 1
        TreeNode p1 = root.left;  // 值为 2 的节点
        TreeNode q1 = root.right;  // 值为 8 的节点
        TreeNode result1 = solution.lowestCommonAncestor(root, p1, q1);
        System.out.println("Test Case 1: " + result1.val);  // 应输出：6
        
        // 测试用例 2
        TreeNode p2 = root.left;  // 值为 2 的节点
        TreeNode q2 = root.left.right;  // 值为 4 的节点
        TreeNode result2 = solution.lowestCommonAncestor(root, p2, q2);
        System.out.println("Test Case 2: " + result2.val);  // 应输出：2
    }
} 