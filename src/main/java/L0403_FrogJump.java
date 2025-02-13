/**
 * https://leetcode.cn/problems/frog-jump/description/
 * 
 * 一只青蛙想要过河。假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] 表示第 i 块石子的位置，每个位置只能有一块石子。
 * 请你判断青蛙能否成功过河（即能否到达最后一块石子）。开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃 1 个单位。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。
 * 
 * 示例 1：
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 块石子（即最后一块石子）。
 * 
 * 示例 2：
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 * 
 * 提示：
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 2^31 - 1
 * stones[0] == 0
 * stones 按严格升序排列
 */
public class L0403_FrogJump {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        // dp[i][k] 表示能否通过跳 k 步到达位置 i
        boolean[][] dp = new boolean[n][n + 1];
        // 初始状态：第一步只能跳 1 个单位
        dp[0][1] = true;
        
        // 遍历每个位置
        for (int i = 1; i < n; i++) {
            // 遍历之前的所有位置
            for (int j = 0; j < i; j++) {
                // 计算从位置 j 跳到位置 i 需要的步数
                int k = stones[i] - stones[j];
                
                // 如果步数超过了 n，说明不可能跳到这个位置
                if (k > n) {
                    continue;
                }
                
                // 如果从位置 j 可以跳 k-1、k 或 k+1 步，那么就可以跳到位置 i
                if (dp[j][k]) {
                    dp[i][k] = true;
                    if (k - 1 >= 0) {
                        dp[i][k - 1] = true;
                    }
                    if (k + 1 <= n) {
                        dp[i][k + 1] = true;
                    }
                }
            }
        }
        
        // 检查是否能到达最后一个位置
        for (int k = 0; k <= n; k++) {
            if (dp[n - 1][k]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L0403_FrogJump solution = new L0403_FrogJump();
        
        // 测试用例1
        int[] stones1 = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println("测试用例1：stones = [0,1,3,5,6,8,12,17]");
        System.out.println("结果：" + solution.canCross(stones1));
        
        // 测试用例2
        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println("\n测试用例2：stones = [0,1,2,3,4,8,9,11]");
        System.out.println("结果：" + solution.canCross(stones2));
    }
} 