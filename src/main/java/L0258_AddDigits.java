/**
 * https://leetcode.cn/problems/add-digits/
 * 
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 * 
 * 示例 1:
 * 输入: num = 38
 * 输出: 2 
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 
 * 示例 2:
 * 输入: num = 0
 * 输出: 0
 * 
 * 提示：
 * - 0 <= num <= 2³¹ - 1
 */
public class L0258_AddDigits {
    
    /**
     * 数学方法：使用数根的概念
     * 数根是将一个数的各个位上的数字相加，得到的数再继续各位相加，直到得到一个一位数为止
     * 对于一个非负整数 n，它的数根 dr(n) 满足：
     * dr(n) = 0，如果 n = 0
     * dr(n) = 9，如果 n ≠ 0 且 n mod 9 = 0
     * dr(n) = n mod 9，如果 n mod 9 ≠ 0
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }

    public static void main(String[] args) {
        L0258_AddDigits solution = new L0258_AddDigits();

        // 测试用例 1
        int num1 = 38;
        System.out.println("测试用例 1：");
        System.out.println("输入：" + num1);
        System.out.println("输出：" + solution.addDigits(num1));
        System.out.println();

        // 测试用例 2
        int num2 = 0;
        System.out.println("测试用例 2：");
        System.out.println("输入：" + num2);
        System.out.println("输出：" + solution.addDigits(num2));
    }
} 