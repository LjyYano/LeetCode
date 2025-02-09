/**
 * https://leetcode.cn/problems/unique-binary-search-trees/
 * 
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg)
 * 输入：n = 3
 * 输出：5
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 
 * 提示：
 * - 1 <= n <= 19
 */
public class L0096_UniqueBinarySearchTrees {
    
    /**
     * 使用动态规划求解不同二叉搜索树的数量
     * 
     * 定义 dp[i] 表示由 i 个节点组成的不同二叉搜索树的数量
     * 对于每个节点 j（1 <= j <= i），以 j 为根节点时：
     * - 左子树由 [1, j-1] 组成，共 j-1 个节点
     * - 右子树由 [j+1, i] 组成，共 i-j 个节点
     * 
     * 状态转移方程：
     * dp[i] = sum(dp[j-1] * dp[i-j]) for j in [1,i]
     * 其中 dp[j-1] 表示左子树的数量，dp[i-j] 表示右子树的数量
     */
    public int numTrees(int n) {
        // dp[i] 表示由 i 个节点组成的不同二叉搜索树的数量
        int[] dp = new int[n + 1];
        
        // 初始化边界条件
        dp[0] = 1; // 空树也是一种情况
        dp[1] = 1; // 只有一个节点的情况
        
        // 从 2 到 n 依次计算每个规模的解
        for (int i = 2; i <= n; i++) {
            // 对于每个规模 i，考虑每个节点作为根节点的情况
            for (int j = 1; j <= i; j++) {
                // 左子树节点数为 j-1，右子树节点数为 i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        L0096_UniqueBinarySearchTrees solution = new L0096_UniqueBinarySearchTrees();

        // 测试用例 1
        int n1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1);
        System.out.println("输出：" + solution.numTrees(n1));
        System.out.println("预期：5");
        System.out.println();

        // 测试用例 2
        int n2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：n = " + n2);
        System.out.println("输出：" + solution.numTrees(n2));
        System.out.println("预期：1");
    }
} 