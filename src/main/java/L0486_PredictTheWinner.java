/**
 * https://leetcode.cn/problems/predict-the-winner/
 * 
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * 
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），
 * 取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。
 * 当数组中没有剩余数字可取时，游戏结束。
 * 
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。
 * 
 * 示例 1：
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。
 * 如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 false 。
 * 
 * 示例 2：
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 
 * 提示：
 * - 1 <= nums.length <= 20
 * - 0 <= nums[i] <= 10^7
 */
public class L0486_PredictTheWinner {
    
    /**
     * 动态规划解法
     * dp[i][j] 表示在 nums[i..j] 范围内，当前玩家与另一个玩家的分数之差的最大值
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        // 初始化：当只有一个数字时，当前玩家直接拿走
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        // 从长度为2的区间开始填表
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // 当前玩家可以选择左端或右端
                // 如果选左端：当前玩家得 nums[i]，对手在 [i+1, j] 中得 dp[i+1][j]
                // 如果选右端：当前玩家得 nums[j]，对手在 [i, j-1] 中得 dp[i][j-1]
                dp[i][j] = Math.max(
                    nums[i] - dp[i + 1][j],
                    nums[j] - dp[i][j - 1]
                );
            }
        }
        
        // 如果玩家1的分数差不小于0，说明玩家1能赢
        return dp[0][n - 1] >= 0;
    }
    
    /**
     * 递归 + 记忆化搜索解法
     */
    public boolean PredictTheWinnerMemo(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return maxDiff(nums, 0, n - 1, memo) >= 0;
    }
    
    /**
     * 计算在 [left, right] 范围内，当前玩家与对手的最大分数差
     */
    private int maxDiff(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) {
            return nums[left];
        }
        
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        
        // 选择左端
        int chooseLeft = nums[left] - maxDiff(nums, left + 1, right, memo);
        // 选择右端
        int chooseRight = nums[right] - maxDiff(nums, left, right - 1, memo);
        
        memo[left][right] = Math.max(chooseLeft, chooseRight);
        return memo[left][right];
    }

    public static void main(String[] args) {
        L0486_PredictTheWinner solution = new L0486_PredictTheWinner();
        
        // 测试用例 1
        int[] nums1 = {1,5,2};
        System.out.println(solution.PredictTheWinner(nums1)); // 预期输出：false
        
        // 测试用例 2
        int[] nums2 = {1,5,233,7};
        System.out.println(solution.PredictTheWinner(nums2)); // 预期输出：true
    }
}
