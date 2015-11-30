package LeetCode;

public class L122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static int maxProfit(int[] prices) {

		if (prices.length <= 1) {
			return 0;
		}

		int hold = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {

			if (hold < prices[i]) {
				profit += prices[i] - hold;
			}
			hold = prices[i];
		}

		return profit;
	}

}
