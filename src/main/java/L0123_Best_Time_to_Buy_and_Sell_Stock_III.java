
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
class L0123_Best_Time_to_Buy_and_Sell_Stock_III {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		/**
		 *  l[i][j]： 第i天可进行j次交易，且最后一次交易在最后一天卖出
		 *  g[i][j]： 第i天最多j次交易的最大利润
		 *  
		 *  l[i][j] = max(l[i-1][j], g[i-1][j-1]) + diff 
		 *  g[i][j] = max(l[i][j], g[i-1][j])
		 *  
		 *  l[i][j]（最后一次交易在最后一天卖出）公式分2种情况：
		 *  1. l[i-1][j] + diff：最后一次交易在i-1天卖出，加上diff相当于i-1天没卖，最后一天卖，不增加交易次数
		 *  2. g[i-1][j-1] + diff： i-1天卖出，结果不会比1好；i-1天未卖出，则可以卖，增加交易次数
		 *  
		 *  可以转化为一维数组 int[3]
		 */
		int[][] l = new int[n][3];
		int[][] g = new int[n][3];

		for (int i = 1; i < n; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= 2; j++) {
				l[i][j] = Math.max(l[i - 1][j], g[i - 1][j - 1]) + diff;
				g[i][j] = Math.max(l[i][j], g[i - 1][j]);
			}
		}

		return g[n - 1][2];
	}
}