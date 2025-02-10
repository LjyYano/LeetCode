/**
 * https://leetcode.cn/problems/counting-bits/
 * 
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 
 * 提示：
 * 0 <= n <= 10⁵
 * 
 * 进阶：
 * - 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * - 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 */
public class L0338_CountingBits {
    
    /**
     * 动态规划解法
     * 对于一个数 x，其二进制中 1 的个数与 x/2 的二进制中 1 的个数有关
     * 如果 x 是偶数，则 x 中 1 的个数与 x/2 相同
     * 如果 x 是奇数，则 x 中 1 的个数比 x/2 多 1
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)，不包括存储答案的空间
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i >> 1 相当于 i/2
            // i & 1 相当于 i%2，用于判断奇偶性
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        L0338_CountingBits solution = new L0338_CountingBits();
        
        // 测试用例 1
        int n1 = 2;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1);
        int[] result1 = solution.countBits(n1);
        System.out.print("输出：[");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.println("预期输出：[0,1,1]");
        System.out.println();
        
        // 测试用例 2
        int n2 = 5;
        System.out.println("测试用例 2：");
        System.out.println("输入：n = " + n2);
        int[] result2 = solution.countBits(n2);
        System.out.print("输出：[");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        System.out.println("预期输出：[0,1,1,2,1,2]");
    }
} 