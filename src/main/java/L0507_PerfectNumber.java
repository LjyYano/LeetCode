/**
 * https://leetcode.cn/problems/perfect-number/
 * 
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * 
 * 示例 1：
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 
 * 示例 2：
 * 输入：num = 7
 * 输出：false
 * 
 * 提示：
 * - 1 <= num <= 10^8
 */
public class L0507_PerfectNumber {
    
    /**
     * 数学方法
     * 只需要遍历到 sqrt(num)
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sum = 1; // 1 一定是因子
        
        // 只需要遍历到 sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        
        return sum == num;
    }

    public static void main(String[] args) {
        L0507_PerfectNumber solution = new L0507_PerfectNumber();
        
        // 测试用例 1
        System.out.println(solution.checkPerfectNumber(28)); // 预期输出：true
        
        // 测试用例 2
        System.out.println(solution.checkPerfectNumber(7)); // 预期输出：false
        
        // 测试用例 3
        System.out.println(solution.checkPerfectNumber(6)); // 预期输出：true (1+2+3=6)
    }
}
