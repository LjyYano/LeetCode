package LeetCode;

public class L121_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {

		if (prices.length <= 1) {
			return 0;
		}

		int maxProfit = 0;
		int lowest = Integer.MAX_VALUE;

		for (int v : prices) {
			lowest = Math.min(v, lowest);
			maxProfit = Math.max(maxProfit, v - lowest);
		}

		return maxProfit;
	}

}
