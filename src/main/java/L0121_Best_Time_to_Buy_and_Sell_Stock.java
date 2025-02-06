
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
class L0121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 存储从prices[0..i]的最小值
        int lowest = Integer.MAX_VALUE;

        for (int v : prices) {
            lowest = Math.min(v, lowest);
            maxProfit = Math.max(maxProfit, v - lowest);
        }

        return maxProfit;
    }
}