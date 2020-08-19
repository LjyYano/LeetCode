
// https://leetcode-cn.com/problems/climbing-stairs/
class L0070_Climbing_Stairs {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        // dp 可以优化为两个数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}