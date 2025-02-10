/*
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 
 * 给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 * 
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */

public class L0309_BestTimeToBuyAndSellStockWithCooldown {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int n = prices.length;
        // hold[i] 表示第 i 天结束时持有股票的最大收益
        // sold[i] 表示第 i 天结束时卖出股票的最大收益
        // rest[i] 表示第 i 天结束时处于冷冻期的最大收益
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];
        
        // 初始化第一天的状态
        hold[0] = -prices[0];  // 第一天买入
        sold[0] = 0;           // 第一天不可能卖出
        rest[0] = 0;           // 第一天不可能处于冷冻期
        
        // 动态规划
        for (int i = 1; i < n; i++) {
            // 第 i 天结束时持有股票：
            // 1. 前一天就持有股票，今天什么都不做
            // 2. 前一天处于冷冻期，今天买入
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            
            // 第 i 天结束时卖出股票：
            // 前一天持有股票，今天卖出
            sold[i] = hold[i - 1] + prices[i];
            
            // 第 i 天结束时处于冷冻期：
            // 1. 前一天卖出股票，今天必须冷冻
            // 2. 前一天就处于冷冻期，今天继续冷冻
            rest[i] = Math.max(sold[i - 1], rest[i - 1]);
        }
        
        // 最后一天结束时，最大收益为卖出股票或处于冷冻期中的较大值
        return Math.max(sold[n - 1], rest[n - 1]);
    }

    public static void main(String[] args) {
        L0309_BestTimeToBuyAndSellStockWithCooldown solution = new L0309_BestTimeToBuyAndSellStockWithCooldown();
        
        // 测试用例 1
        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(prices1)); // 应输出 3
        
        // 测试用例 2
        int[] prices2 = {1};
        System.out.println(solution.maxProfit(prices2)); // 应输出 0
        
        // 测试用例 3
        int[] prices3 = {1, 2, 4};
        System.out.println(solution.maxProfit(prices3)); // 应输出 3
        
        // 测试用例 4
        int[] prices4 = {2, 1, 4};
        System.out.println(solution.maxProfit(prices4)); // 应输出 3
    }
} 