/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 
 * 提示：
 * - 0 <= k <= 100
 * - 0 <= prices.length <= 1000
 * - 0 <= prices[i] <= 1000
 */
public class L0188_BestTimeToBuyAndSellStockIV {
    
    /**
     * 动态规划解法
     * dp[i][j][0] 表示第 i 天，已进行 j 次交易，手上没有股票的最大利润
     * dp[i][j][1] 表示第 i 天，已进行 j 次交易，手上持有股票的最大利润
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        
        // 如果 k 超过了最大可能的交易次数，相当于无限次交易
        if (k >= prices.length / 2) {
            return maxProfitUnlimited(prices);
        }
        
        // dp[天数][交易次数][是否持有股票]
        int[][][] dp = new int[prices.length][k + 1][2];
        
        // 初始化第一天的状态
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        
        // 遍历每一天
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                // 第 i 天不持有股票：
                // 1. 前一天也不持有
                // 2. 前一天持有，今天卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                
                // 第 i 天持有股票：
                // 1. 前一天就持有
                // 2. 前一天不持有，今天买入（这种情况要减少一次交易次数）
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        
        return dp[prices.length - 1][k][0];
    }
    
    /**
     * 处理无限次交易的情况
     * 只要有利润就可以交易
     */
    private int maxProfitUnlimited(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        L0188_BestTimeToBuyAndSellStockIV solution = new L0188_BestTimeToBuyAndSellStockIV();
        
        // 测试用例 1
        int k1 = 2;
        int[] prices1 = {2, 4, 1};
        System.out.println("测试用例 1：");
        System.out.println("输入：k = " + k1 + ", prices = " + java.util.Arrays.toString(prices1));
        System.out.println("输出：" + solution.maxProfit(k1, prices1));
        
        // 测试用例 2
        int k2 = 2;
        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println("\n测试用例 2：");
        System.out.println("输入：k = " + k2 + ", prices = " + java.util.Arrays.toString(prices2));
        System.out.println("输出：" + solution.maxProfit(k2, prices2));
    }
} 