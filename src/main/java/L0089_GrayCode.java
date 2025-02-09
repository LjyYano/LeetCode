import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/gray-code/
 * 
 * n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
 * 1. 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1）
 * 2. 第一个整数是 0
 * 3. 一个整数在序列中出现 不超过一次
 * 4. 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 5. 第一个和最后一个整数的二进制表示 恰好一位不同
 * 
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 * 
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,3,2]
 * 解释：
 * [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 * - 00 和 01 有一位不同
 * - 01 和 11 有一位不同
 * - 11 和 10 有一位不同
 * - 10 和 00 有一位不同
 * [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 * - 00 和 10 有一位不同
 * - 10 和 11 有一位不同
 * - 11 和 01 有一位不同
 * - 01 和 00 有一位不同
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：[0,1]
 * 
 * 提示：
 * - 1 <= n <= 16
 */
public class L0089_GrayCode {
    
    public List<Integer> grayCode(int n) {
        // 结果列表，初始容量为 2ⁿ
        List<Integer> result = new ArrayList<>(1 << n);
        // 添加第一个数字 0
        result.add(0);
        
        // 对于每一位，我们都将之前的序列倒序遍历，并在最高位加 1
        for (int i = 0; i < n; i++) {
            // 当前位的掩码，例如：i = 0 时为 1，i = 1 时为 2，i = 2 时为 4
            int mask = 1 << i;
            // 倒序遍历之前的序列
            for (int j = result.size() - 1; j >= 0; j--) {
                // 在最高位加 1，相当于将之前的数字加上 2^i
                result.add(result.get(j) | mask);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0089_GrayCode solution = new L0089_GrayCode();

        // 测试用例 1
        int n1 = 2;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1);
        List<Integer> result1 = solution.grayCode(n1);
        System.out.println("输出：" + result1);
        System.out.println("二进制表示：");
        printBinary(result1, n1);
        System.out.println();

        // 测试用例 2
        int n2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：n = " + n2);
        List<Integer> result2 = solution.grayCode(n2);
        System.out.println("输出：" + result2);
        System.out.println("二进制表示：");
        printBinary(result2, n2);
        System.out.println();

        // 测试用例 3
        int n3 = 3;
        System.out.println("测试用例 3：");
        System.out.println("输入：n = " + n3);
        List<Integer> result3 = solution.grayCode(n3);
        System.out.println("输出：" + result3);
        System.out.println("二进制表示：");
        printBinary(result3, n3);
    }

    // 辅助方法：打印二进制表示
    private static void printBinary(List<Integer> nums, int n) {
        for (int num : nums) {
            // 将数字转换为二进制字符串，并补齐前导零
            String binary = String.format("%" + n + "s", 
                Integer.toBinaryString(num)).replace(' ', '0');
            System.out.println(binary);
        }
    }
} 