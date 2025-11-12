/**
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 * 
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。
 * 如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 
 * 示例 1：
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 
 * 示例 2：
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * 
 * 提示：
 * - 节点数在 [1, 10^4] 范围内
 * - -10^5 <= Node.val <= 10^5
 */
import common.TreeNode;
import java.util.*;

public class L0508_MostFrequentSubtreeSum {
    
    private Map<Integer, Integer> sumCount = new HashMap<>();
    private int maxCount = 0;
    
    /**
     * 后序遍历 + 哈希表
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        int sum = node.val + leftSum + rightSum;
        
        sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, sumCount.get(sum));
        
        return sum;
    }

    public static void main(String[] args) {
        L0508_MostFrequentSubtreeSum solution = new L0508_MostFrequentSubtreeSum();
        
        // 测试用例 1: [5,2,-3]
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-3);
        int[] result1 = solution.findFrequentTreeSum(root1);
        System.out.println(Arrays.toString(result1)); // 预期输出：[2,-3,4]
        
        // 测试用例 2: [5,2,-5]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(-5);
        int[] result2 = solution.findFrequentTreeSum(root2);
        System.out.println(Arrays.toString(result2)); // 预期输出：[2]
    }
}
