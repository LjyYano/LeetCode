/*
 * https://leetcode.cn/problems/additive-number/
 * 
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * 
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 * 
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 * 
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 
 * 示例 1：
 * 输入："112358"
 * 输出：true 
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * 示例 2：
 * 输入："199100199"
 * 输出：true 
 * 解释：累加序列为: 1, 99, 100, 199
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * 提示：
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 */

public class L0306_AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        // 第一个数字的长度至少为 1，最长不超过 n/2
        for (int i = 1; i <= n / 2; i++) {
            // 如果第一个数字以 0 开头且长度大于 1，跳过
            if (num.charAt(0) == '0' && i > 1) {
                continue;
            }
            // 第二个数字的长度至少为 1，且剩余长度要足够容纳第三个数字
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                // 如果第二个数字以 0 开头且长度大于 1，跳过
                if (num.charAt(i) == '0' && j > 1) {
                    continue;
                }
                // 检查从当前位置开始是否能形成累加序列
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 检查从指定位置开始，是否能形成累加序列
    private boolean isValid(String num, int i, int j) {
        int n = num.length();
        // 获取前两个数字
        long num1 = Long.parseLong(num.substring(0, i));
        long num2 = Long.parseLong(num.substring(i, i + j));
        
        int start = i + j;
        while (start < n) {
            // 计算下一个数字
            num2 = num2 + num1;
            num1 = num2 - num1;
            // 转换为字符串进行比较
            String sum = String.valueOf(num2);
            // 如果剩余字符串长度小于 sum 的长度，或者不是以 sum 开头，返回 false
            if (start + sum.length() > n || !num.startsWith(sum, start)) {
                return false;
            }
            start += sum.length();
        }
        // 必须至少包含 3 个数字
        return start == n && i + j < n;
    }

    public static void main(String[] args) {
        L0306_AdditiveNumber solution = new L0306_AdditiveNumber();
        
        // 测试用例 1
        System.out.println(solution.isAdditiveNumber("112358")); // 应输出 true
        
        // 测试用例 2
        System.out.println(solution.isAdditiveNumber("199100199")); // 应输出 true
        
        // 测试用例 3
        System.out.println(solution.isAdditiveNumber("1023")); // 应输出 false
        
        // 测试用例 4
        System.out.println(solution.isAdditiveNumber("101")); // 应输出 true
    }
} 