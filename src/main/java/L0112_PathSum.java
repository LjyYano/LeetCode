import common.TreeNode;

/**
 * https://leetcode.cn/problems/path-sum/
 * 
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。
 * 如果存在，返回 true；否则，返回 false。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg)
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶子节点路径如图所示。
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * 
 * 提示：
 * - 树中节点的数目在范围 [0, 5000] 内
 * - -1000 <= Node.val <= 1000
 * - -1000 <= targetSum <= 1000
 */
public class L0112_PathSum {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 如果根节点为空，返回 false
        if (root == null) {
            return false;
        }
        
        // 如果是叶子节点，判断当前节点值是否等于目标和
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        // 递归判断左右子树是否存在路径和为 targetSum - root.val 的路径
        return hasPathSum(root.left, targetSum - root.val) || 
               hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        L0112_PathSum solution = new L0112_PathSum();

        // 测试用例 1：[5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.right = new TreeNode(1);
        System.out.println("测试用例 1：输入 [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22");
        System.out.println("输出：" + solution.hasPathSum(root1, 22));

        // 测试用例 2：[1,2,3], targetSum = 5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("测试用例 2：输入 [1,2,3], targetSum = 5");
        System.out.println("输出：" + solution.hasPathSum(root2, 5));

        // 测试用例 3：[], targetSum = 0
        System.out.println("测试用例 3：输入 [], targetSum = 0");
        System.out.println("输出：" + solution.hasPathSum(null, 0));
    }
} 