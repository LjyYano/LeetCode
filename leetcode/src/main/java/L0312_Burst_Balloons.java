
// https://leetcode-cn.com/problems/burst-balloons/
public class L0312_Burst_Balloons {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m)
                    dp[l][r] = Math.max(dp[l][r], 
                        nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
            }
    
        return dp[0][n - 1];
    }
}