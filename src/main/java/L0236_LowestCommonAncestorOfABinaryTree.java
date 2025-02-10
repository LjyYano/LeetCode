/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为："对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。"
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * 
 * 提示：
 * - 树中节点数目在范围 [2, 10⁵] 内。
 * - -10⁹ <= Node.val <= 10⁹
 * - 所有 Node.val 互不相同。
 * - p != q
 * - p 和 q 均存在于给定的二叉树中。
 */
public class L0236_LowestCommonAncestorOfABinaryTree {
    
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
    
    /**
     * 递归查找最近公共祖先
     * 对于当前节点：
     * 1. 如果当前节点为空，或者等于 p 或 q，直接返回当前节点
     * 2. 递归在左右子树中查找 p 和 q
     * 3. 如果左右子树的返回值都不为空，说明 p 和 q 分别在左右子树中，当前节点就是最近公共祖先
     * 4. 如果只有一个子树的返回值不为空，说明 p 和 q 都在这个子树中，返回这个子树的查找结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，或者等于 p 或 q，直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // 递归在左右子树中查找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 如果左右子树的返回值都不为空，说明 p 和 q 分别在左右子树中
        if (left != null && right != null) {
            return root;
        }
        
        // 如果只有一个子树的返回值不为空，说明 p 和 q 都在这个子树中
        return left != null ? left : right;
    }
    
    public static void main(String[] args) {
        L0236_LowestCommonAncestorOfABinaryTree solution = new L0236_LowestCommonAncestorOfABinaryTree();
        
        // 构建示例 1 中的二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        
        // 测试用例 1
        TreeNode p1 = root.left;  // 值为 5 的节点
        TreeNode q1 = root.right;  // 值为 1 的节点
        TreeNode result1 = solution.lowestCommonAncestor(root, p1, q1);
        System.out.println("Test Case 1: " + result1.val);  // 应输出：3
        
        // 测试用例 2
        TreeNode p2 = root.left;  // 值为 5 的节点
        TreeNode q2 = root.left.right.right;  // 值为 4 的节点
        TreeNode result2 = solution.lowestCommonAncestor(root, p2, q2);
        System.out.println("Test Case 2: " + result2.val);  // 应输出：5
    }
} 