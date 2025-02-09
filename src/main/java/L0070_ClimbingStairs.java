/**
 * https://leetcode.cn/problems/climbing-stairs/
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 
 * 提示：
 * 1 <= n <= 45
 */
public class L0070_ClimbingStairs {

    // 使用动态规划求解
    public int climbStairs(int n) {
        // 特殊情况处理
        if (n <= 2) {
            return n;
        }

        // dp[i] 表示爬到第 i 阶楼梯的方法数
        int[] dp = new int[n + 1];
        
        // 初始化基础情况
        dp[1] = 1; // 爬到第 1 阶楼梯只有 1 种方法
        dp[2] = 2; // 爬到第 2 阶楼梯有 2 种方法
        
        // 从第 3 阶开始计算
        for (int i = 3; i <= n; i++) {
            // 爬到第 i 阶的方法数等于爬到第 i-1 阶的方法数加上爬到第 i-2 阶的方法数
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    // 使用滚动数组优化空间复杂度
    public int climbStairsOptimized(int n) {
        // 特殊情况处理
        if (n <= 2) {
            return n;
        }

        // 只需要记录前两个状态
        int prev = 1;  // dp[i-2]
        int curr = 2;  // dp[i-1]
        
        // 从第 3 阶开始计算
        for (int i = 3; i <= n; i++) {
            // 计算当前状态
            int next = prev + curr;
            // 更新状态
            prev = curr;
            curr = next;
        }
        
        return curr;
    }

    public static void main(String[] args) {
        L0070_ClimbingStairs solution = new L0070_ClimbingStairs();

        // 测试用例 1
        int n1 = 2;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.climbStairs(n1));
        System.out.println("Output (Optimized): " + solution.climbStairsOptimized(n1));
        System.out.println();

        // 测试用例 2
        int n2 = 3;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.climbStairs(n2));
        System.out.println("Output (Optimized): " + solution.climbStairsOptimized(n2));
        System.out.println();

        // 测试用例 3：较大的数
        int n3 = 10;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + solution.climbStairs(n3));
        System.out.println("Output (Optimized): " + solution.climbStairsOptimized(n3));
    }
} 