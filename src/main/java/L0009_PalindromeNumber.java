/**
 * 题目链接：https://leetcode.cn/problems/palindrome-number/
 * 
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class L0009_PalindromeNumber {
    
    public boolean isPalindrome(int x) {
        // 负数不是回文数
        // 如果个位数是 0，只有 0 本身是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        // 反转后半部分数字
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除中位数
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        L0009_PalindromeNumber solution = new L0009_PalindromeNumber();
        
        // 测试用例 1：回文数
        int x1 = 121;
        System.out.println("输入：" + x1);
        System.out.println("输出：" + solution.isPalindrome(x1));  // 预期输出：true
        
        // 测试用例 2：非回文数
        int x2 = -121;
        System.out.println("\n输入：" + x2);
        System.out.println("输出：" + solution.isPalindrome(x2));  // 预期输出：false
        
        // 测试用例 3：末尾有零
        int x3 = 10;
        System.out.println("\n输入：" + x3);
        System.out.println("输出：" + solution.isPalindrome(x3));  // 预期输出：false
        
        // 测试用例 4：单个数字
        int x4 = 0;
        System.out.println("\n输入：" + x4);
        System.out.println("输出：" + solution.isPalindrome(x4));  // 预期输出：true
    }
} 