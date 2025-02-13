/**
 * https://leetcode.cn/problems/path-sum-iii/description/
 * 
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的路径的数目。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 */
public class L0437_PathSumIII {

    // 定义二叉树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        // 以当前节点为起点的路径数量
        int count = dfs(root, targetSum);
        
        // 递归统计左右子树中的路径数量
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        
        return count;
    }
    
    /**
     * 统计以当前节点为起点，和为 targetSum 的路径数量
     */
    private int dfs(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        // 如果当前节点值等于目标值，找到一条路径
        if (node.val == targetSum) {
            count++;
        }
        
        // 继续搜索左右子树，注意更新目标值
        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);
        
        return count;
    }

    public static void main(String[] args) {
        L0437_PathSumIII solution = new L0437_PathSumIII();
        
        // 测试用例1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);
        
        System.out.println("测试用例1：");
        System.out.println("输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8");
        System.out.println("输出：" + solution.pathSum(root1, 8));
        
        // 测试用例2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);
        
        System.out.println("\n测试用例2：");
        System.out.println("输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22");
        System.out.println("输出：" + solution.pathSum(root2, 22));
    }
} 