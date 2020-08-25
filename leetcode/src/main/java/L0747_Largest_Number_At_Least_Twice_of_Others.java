
// https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
class L0747_Largest_Number_At_Least_Twice_of_Others {
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] result = new int[n];
		result[0] = cost[0];
		result[1] = cost[1];
		
		for(int i = 2; i < n; i++) {
			result[i] = Math.min(result[i-1], result[i-2]) + cost[i];
		}
		return Math.min(result[n - 1], result[n - 2]);
	}
}