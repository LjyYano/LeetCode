/**
 * https://leetcode.cn/problems/bitwise-and-of-numbers-range/
 * 
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * 
 * 示例 1：
 * 输入：left = 5, right = 7
 * 输出：4
 * 解释：5 & 6 & 7 = 4
 * 
 * 示例 2：
 * 输入：left = 0, right = 0
 * 输出：0
 * 
 * 示例 3：
 * 输入：left = 1, right = 2147483647
 * 输出：0
 * 
 * 提示：
 * - 0 <= left <= right <= 2^31 - 1
 */
public class L0201_BitwiseANDOfNumbersRange {
    
    /**
     * 位移解法
     * 关键观察：区间 [left, right] 的按位与结果等于 left 和 right 的公共前缀
     * 因为在区间内，较低位的数字会在某个时刻从 0 变为 1，再从 1 变为 0
     * 只有公共前缀部分在整个区间内保持不变
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // 将公共前缀左移回原来的位置
        return left << shift;
    }

    public static void main(String[] args) {
        L0201_BitwiseANDOfNumbersRange solution = new L0201_BitwiseANDOfNumbersRange();
        
        // 测试用例 1
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // 预期输出：4
        
        // 测试用例 2
        System.out.println(solution.rangeBitwiseAnd(0, 0)); // 预期输出：0
        
        // 测试用例 3
        System.out.println(solution.rangeBitwiseAnd(1, 2147483647)); // 预期输出：0
    }
}
