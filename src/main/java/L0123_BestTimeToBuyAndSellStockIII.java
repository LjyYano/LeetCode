import java.util.Arrays;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 
 * 示例 3：
 * 输入：prices = [7,6,4,3,1] 
 * 输出：0 
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 示例 4：
 * 输入：prices = [1]
 * 输出：0
 * 
 * 提示：
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁵
 */
public class L0123_BestTimeToBuyAndSellStockIII {

    /**
     * 使用动态规划解决问题
     * 
     * 状态定义：
     * dp[i][k][0] 表示第 i 天，最多进行 k 次交易，手上没有股票的最大利润
     * dp[i][k][1] 表示第 i 天，最多进行 k 次交易，手上持有股票的最大利润
     * 
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * 
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        // 由于最多进行 2 次交易，所以 k = 2
        int[][][] dp = new int[n][3][2];

        // 初始化第一天的状态
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        // 动态规划过程
        for (int i = 1; i < n; i++) {
            // 第一次交易
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            // 第二次交易
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }

        // 最终结果是最多进行两次交易，且手上没有股票的情况
        return dp[n - 1][2][0];
    }

    public static void main(String[] args) {
        L0123_BestTimeToBuyAndSellStockIII solution = new L0123_BestTimeToBuyAndSellStockIII();

        // 测试用例 1
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Test Case 1: " + solution.maxProfit(prices1)); // 预期输出：6

        // 测试用例 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + solution.maxProfit(prices2)); // 预期输出：4

        // 测试用例 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 3: " + solution.maxProfit(prices3)); // 预期输出：0
    }
} 