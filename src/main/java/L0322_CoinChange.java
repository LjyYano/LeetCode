/**
 * https://leetcode.cn/problems/coin-change/
 * 
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 提示：
 * - 1 <= coins.length <= 12
 * - 1 <= coins[i] <= 2³¹ - 1
 * - 0 <= amount <= 10⁴
 */
public class L0322_CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        // 创建 dp 数组，dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        
        // 初始化 dp 数组，除了 dp[0] = 0，其他都初始化为一个不可能的值
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        
        // 动态规划
        for (int i = 1; i <= amount; i++) {
            // 对于每个金额 i，尝试使用每个硬币
            for (int coin : coins) {
                if (coin <= i) {
                    // 状态转移方程：dp[i] = min(dp[i], dp[i-coin] + 1)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // 如果 dp[amount] 仍然大于 amount，说明无解
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        L0322_CoinChange solution = new L0322_CoinChange();
        
        // 测试用例 1
        int[] coins1 = {1, 2, 5};
        System.out.println(solution.coinChange(coins1, 11));  // 应输出 3
        
        // 测试用例 2
        int[] coins2 = {2};
        System.out.println(solution.coinChange(coins2, 3));   // 应输出 -1
        
        // 测试用例 3
        int[] coins3 = {1};
        System.out.println(solution.coinChange(coins3, 0));   // 应输出 0
        
        // 测试用例 4
        int[] coins4 = {1, 2, 5, 10};
        System.out.println(solution.coinChange(coins4, 18));  // 应输出 4
    }
} 