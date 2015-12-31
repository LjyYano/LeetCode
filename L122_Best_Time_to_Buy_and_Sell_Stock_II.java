package LeetCode;

public class L122_Best_Time_to_Buy_and_Sell_Stock_II {

	public int maxProfit(int[] prices) {

		int profit = 0;

		for (int i = 1; i < prices.length; i++) {

			if (prices[i - 1] < prices[i]) {
				profit += prices[i] - prices[i - 1];
			}
		}

		return profit;
	}

}
