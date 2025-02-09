/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 提示：
 * - 1 <= prices.length <= 10⁵
 * - 0 <= prices[i] <= 10⁴
 */
public class L0121_BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        // 记录最低价格
        int minPrice = prices[0];
        // 记录最大利润
        int maxProfit = 0;
        
        // 遍历价格数组
        for (int i = 1; i < prices.length; i++) {
            // 更新最低价格
            minPrice = Math.min(minPrice, prices[i]);
            // 计算当前价格卖出的利润，并更新最大利润
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        L0121_BestTimeToBuyAndSellStock solution = new L0121_BestTimeToBuyAndSellStock();

        // 测试用例 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("测试用例 1：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices1));
        System.out.println("输出：" + solution.maxProfit(prices1));
        System.out.println("预期：5");
        System.out.println();

        // 测试用例 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("测试用例 2：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices2));
        System.out.println("输出：" + solution.maxProfit(prices2));
        System.out.println("预期：0");
        System.out.println();

        // 测试用例 3：价格持续上涨
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("测试用例 3：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices3));
        System.out.println("输出：" + solution.maxProfit(prices3));
        System.out.println("预期：4");
    }
} 