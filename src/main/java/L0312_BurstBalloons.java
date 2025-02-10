/*
 * https://leetcode.cn/problems/burst-balloons/
 * 
 * 有 n 个气球，编号为 0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1 或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 15 + 120 + 24 + 8 = 167
 * 
 * 示例 2：
 * 输入：nums = [1,5]
 * 输出：10
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 */

public class L0312_BurstBalloons {
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 创建一个新的数组，在首尾各添加一个 1
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        
        // dp[i][j] 表示戳破 (i,j) 开区间内的所有气球能得到的最大硬币数
        int[][] dp = new int[n + 2][n + 2];
        
        // len 表示开区间的长度
        for (int len = 1; len <= n; len++) {
            // i 表示开区间的左端点
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;  // j 表示开区间的右端点
                // k 表示最后一个被戳破的气球
                for (int k = i; k <= j; k++) {
                    // 计算戳破气球 k 时获得的硬币数
                    int coins = newNums[i - 1] * newNums[k] * newNums[j + 1];
                    // 加上戳破左右两边气球能得到的最大硬币数
                    coins += dp[i][k - 1] + dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        
        return dp[1][n];
    }

    public static void main(String[] args) {
        L0312_BurstBalloons solution = new L0312_BurstBalloons();
        
        // 测试用例 1
        int[] nums1 = {3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums1)); // 应输出 167
        
        // 测试用例 2
        int[] nums2 = {1, 5};
        System.out.println(solution.maxCoins(nums2)); // 应输出 10
        
        // 测试用例 3
        int[] nums3 = {7};
        System.out.println(solution.maxCoins(nums3)); // 应输出 7
        
        // 测试用例 4
        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxCoins(nums4)); // 应输出 110
    }
} 