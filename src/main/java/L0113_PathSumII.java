import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/
 * 
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsumii1.jpg)
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/pathsum2.jpg)
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * 
 * 提示：
 * - 树中节点总数在范围 [0, 5000] 内
 * - -1000 <= Node.val <= 1000
 * - -1000 <= targetSum <= 1000
 */
public class L0113_PathSumII {
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果根节点为空，直接返回空列表
        if (root == null) {
            return result;
        }
        
        // 用于存储当前路径
        List<Integer> currentPath = new ArrayList<>();
        // 递归查找所有路径
        dfs(root, targetSum, currentPath, result);
        return result;
    }
    
    /**
     * 深度优先搜索查找所有满足条件的路径
     * 
     * @param node 当前节点
     * @param targetSum 目标和
     * @param currentPath 当前路径
     * @param result 结果集
     */
    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        // 将当前节点加入路径
        currentPath.add(node.val);
        
        // 如果是叶子节点，且路径和等于目标和，将当前路径加入结果集
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        }
        
        // 递归遍历左子树
        if (node.left != null) {
            dfs(node.left, targetSum - node.val, currentPath, result);
        }
        
        // 递归遍历右子树
        if (node.right != null) {
            dfs(node.right, targetSum - node.val, currentPath, result);
        }
        
        // 回溯：移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        L0113_PathSumII solution = new L0113_PathSumII();

        // 测试用例 1：[5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        System.out.println("测试用例 1：输入 [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22");
        System.out.println("输出：" + solution.pathSum(root1, 22));

        // 测试用例 2：[1,2,3], targetSum = 5
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("测试用例 2：输入 [1,2,3], targetSum = 5");
        System.out.println("输出：" + solution.pathSum(root2, 5));

        // 测试用例 3：[1,2], targetSum = 0
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        System.out.println("测试用例 3：输入 [1,2], targetSum = 0");
        System.out.println("输出：" + solution.pathSum(root3, 0));
    }
} 