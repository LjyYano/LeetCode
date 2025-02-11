import java.util.Arrays;

/**
 * https://leetcode.cn/problems/guess-number-higher-or-lower-ii/
 * 
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 1. 我从 1 到 n 之间选择一个数字。
 * 2. 你来猜我选了哪个数字。
 * 3. 如果你猜到正确的数字，就会 赢得游戏 。
 * 4. 如果你猜错了，那么我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 5. 你可以通过支付 x 元获得数字 x 的提示。
 * 
 * 给你一个数字 n ，返回你确保获胜的最小现金数，不管我选择那个数字。
 * 
 * 示例 1：
 * 输入：n = 10
 * 输出：16
 * 解释：制胜策略如下：
 * - 数字范围是 [1,10] 。你先猜测数字为 7 。
 *     - 如果这是我选中的数字，你的总费用为 $0 。否则，你需要支付 $7 。
 *     - 如果我的数字更大，则下一步需要猜测的数字范围是 [8,10] 。你可以猜测数字为 9 。
 *         - 如果这是我选中的数字，你的总费用为 $7 。否则，你需要支付 $9 。
 *         - 如果我的数字更大，那么这个数字一定是 10 。你猜测数字为 10 并赢得游戏，总费用为 $7 + $9 = $16 。
 *         - 如果我的数字更小，那么这个数字一定是 8 。你猜测数字为 8 并赢得游戏，总费用为 $7 + $9 = $16 。
 *     - 如果我的数字更小，则下一步需要猜测的数字范围是 [1,6] 。你可以猜测数字为 3 。
 *         - 如果这是我选中的数字，你的总费用为 $7 。否则，你需要支付 $3 。
 *         - 如果我的数字更大，则下一步需要猜测的数字范围是 [4,6] 。你可以猜测数字为 5 。
 *             - 如果这是我选中的数字，你的总费用为 $7 + $3 = $10 。否则，你需要支付 $5 。
 *             - 如果我的数字更大，那么这个数字一定是 6 。你猜测数字为 6 并赢得游戏，总费用为 $7 + $3 + $5 = $15 。
 *             - 如果我的数字更小，那么这个数字一定是 4 。你猜测数字为 4 并赢得游戏，总费用为 $7 + $3 + $5 = $15 。
 *         - 如果我的数字更小，则下一步需要猜测的数字范围是 [1,2] 。你可以猜测数字为 1 。
 *             - 如果这是我选中的数字，你的总费用为 $7 + $3 = $10 。否则，你需要支付 $1 。
 *             - 如果我的数字更大，那么这个数字一定是 2 。你猜测数字为 2 并赢得游戏，总费用为 $7 + $3 + $1 = $11 。
 * 在最糟糕的情况下，你需要支付 $16 。因此，你只需要 $16 就可以确保自己赢得游戏。
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：0
 * 解释：只有一个可能的数字，所以你可以直接猜 1 并赢得游戏，无需支付任何费用。
 * 
 * 示例 3：
 * 输入：n = 2
 * 输出：1
 * 解释：有两个可能的数字 1 和 2 。
 * - 你可以先猜 1 。
 *     - 如果这是我选中的数字，你的总费用为 $0 。
 *     - 如果我的数字更大，那么这个数字一定是 2 。你猜测数字为 2 并赢得游戏，总费用为 $1 。
 * 最糟糕的情况下，你需要支付 $1 。
 * 
 * 提示：
 * - 1 <= n <= 200
 */
public class L0375_GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        // dp[i][j] 表示在范围 [i,j] 内确保获胜的最小现金数
        int[][] dp = new int[n + 1][n + 1];
        
        // 初始化 dp 数组
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        // 计算不同长度的区间
        for (int len = 2; len <= n; len++) {
            // 遍历所有可能的起点
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                // 初始化为最大值
                dp[start][end] = Integer.MAX_VALUE;
                
                // 尝试每个可能的猜测点
                for (int guess = start; guess <= end; guess++) {
                    // 当前猜测点的最坏情况开销
                    int cost = guess + Math.max(
                        guess > start ? dp[start][guess - 1] : 0,
                        guess < end ? dp[guess + 1][end] : 0
                    );
                    // 更新最小开销
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }
        
        return dp[1][n];
    }

    public static void main(String[] args) {
        L0375_GuessNumberHigherOrLowerII solution = new L0375_GuessNumberHigherOrLowerII();
        
        // 测试用例 1
        System.out.println(solution.getMoneyAmount(10)); // 预期输出：16
        
        // 测试用例 2
        System.out.println(solution.getMoneyAmount(1));  // 预期输出：0
        
        // 测试用例 3
        System.out.println(solution.getMoneyAmount(2));  // 预期输出：1
        
        // 测试用例 4
        System.out.println(solution.getMoneyAmount(3));  // 预期输出：2
    }
} 