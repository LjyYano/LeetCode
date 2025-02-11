/**
 * https://leetcode.cn/problems/nth-digit/
 * 
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：3
 * 
 * 示例 2：
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * 
 * 提示：
 * 1 <= n <= 2³¹ - 1
 */
public class L0400_NthDigit {
    
    public int findNthDigit(int n) {
        // 处理特殊情况
        if (n < 10) {
            return n;
        }
        
        // 1. 确定 n 所在的数字的位数
        long length = 1;  // 数字的位数
        long count = 9;   // 当前位数的数字个数
        long start = 1;   // 当前位数的起始数字
        
        // n 减去前面的位数，直到找到所在的数字范围
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        // 2. 确定 n 所在的具体数字
        // 减去 1 是因为要考虑从 0 开始计数
        start += (n - 1) / length;
        
        // 3. 从该数字中取出第 n 位
        // 将数字转为字符串，然后取出对应位置的数字
        String number = String.valueOf(start);
        return number.charAt((n - 1) % (int)length) - '0';
    }

    public static void main(String[] args) {
        L0400_NthDigit solution = new L0400_NthDigit();
        
        // 测试用例 1
        System.out.println("n = 3, 结果: " + solution.findNthDigit(3));  // 应输出 3
        
        // 测试用例 2
        System.out.println("n = 11, 结果: " + solution.findNthDigit(11));  // 应输出 0
        
        // 测试用例 3：较大的数
        System.out.println("n = 1000, 结果: " + solution.findNthDigit(1000));
        
        // 测试边界情况
        System.out.println("n = 1, 结果: " + solution.findNthDigit(1));  // 应输出 1
        System.out.println("n = 9, 结果: " + solution.findNthDigit(9));  // 应输出 9
    }
} 