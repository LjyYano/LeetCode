/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 * 
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 *      总利润为 4 + 3 = 7。
 * 
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 *      总利润为 4。
 * 
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
 * 
 * 提示：
 * - 1 <= prices.length <= 3 * 10⁴
 * - 0 <= prices[i] <= 10⁴
 */
public class L0122_BestTimeToBuyAndSellStockII {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        // 记录总利润
        int totalProfit = 0;
        
        // 遍历价格数组，只要后一天价格比前一天高，就可以获取利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        
        return totalProfit;
    }

    public static void main(String[] args) {
        L0122_BestTimeToBuyAndSellStockII solution = new L0122_BestTimeToBuyAndSellStockII();

        // 测试用例 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("测试用例 1：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices1));
        System.out.println("输出：" + solution.maxProfit(prices1));
        System.out.println("预期：7");
        System.out.println();

        // 测试用例 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("测试用例 2：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices2));
        System.out.println("输出：" + solution.maxProfit(prices2));
        System.out.println("预期：4");
        System.out.println();

        // 测试用例 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("测试用例 3：");
        System.out.println("输入：prices = " + java.util.Arrays.toString(prices3));
        System.out.println("输出：" + solution.maxProfit(prices3));
        System.out.println("预期：0");
    }
} 