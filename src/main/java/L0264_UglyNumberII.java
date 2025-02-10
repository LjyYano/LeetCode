/**
 * https://leetcode.cn/problems/ugly-number-ii/
 * 
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * 
 * 提示：
 * 1 <= n <= 1690
 */
public class L0264_UglyNumberII {
    
    // 使用动态规划，三指针法
    // dp[i] 表示第 i+1 个丑数
    // 每个丑数都是由之前的某个丑数乘以 2、3 或 5 得到的
    public int nthUglyNumber(int n) {
        // dp[i] 表示第 i+1 个丑数
        int[] dp = new int[n];
        // 第一个丑数是 1
        dp[0] = 1;
        
        // p2、p3、p5 分别表示下一个丑数是当前指针指向的丑数乘以对应的质因数
        int p2 = 0, p3 = 0, p5 = 0;
        
        // 从第二个丑数开始计算
        for (int i = 1; i < n; i++) {
            // 下一个丑数是三个候选中的最小值
            int next2 = dp[p2] * 2;
            int next3 = dp[p3] * 3;
            int next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            
            // 如果最小值是某个候选值，对应的指针向前移动
            if (dp[i] == next2) {
                p2++;
            }
            if (dp[i] == next3) {
                p3++;
            }
            if (dp[i] == next5) {
                p5++;
            }
        }
        
        // 返回第 n 个丑数
        return dp[n - 1];
    }

    public static void main(String[] args) {
        L0264_UglyNumberII solution = new L0264_UglyNumberII();
        
        // 测试用例 1
        System.out.println(solution.nthUglyNumber(10));  // 应该输出 12
        
        // 测试用例 2
        System.out.println(solution.nthUglyNumber(1));   // 应该输出 1
        
        // 测试用例 3：较大的数
        System.out.println(solution.nthUglyNumber(15));  // 应该输出 24
        
        // 测试用例 4：边界值
        System.out.println(solution.nthUglyNumber(1690)); // 应该输出 2123366400
    }
} 