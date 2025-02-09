import java.util.*;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 * 
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 
 * 字母和数字都属于字母数字字符。
 * 
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 * 
 * 提示：
 * - 1 <= s.length <= 2 * 10⁵
 * - s 仅由可打印的 ASCII 字符组成
 */
public class L0125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        // 双指针法
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            // 找到左边第一个字母或数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 找到右边第一个字母或数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 比较两个字符是否相等（忽略大小写）
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0125_ValidPalindrome solution = new L0125_ValidPalindrome();
        
        // 测试用例 1：普通回文串
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("测试用例 1：");
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.isPalindrome(s1));
        System.out.println("预期：true");
        System.out.println();
        
        // 测试用例 2：非回文串
        String s2 = "race a car";
        System.out.println("测试用例 2：");
        System.out.println("输入：" + s2);
        System.out.println("输出：" + solution.isPalindrome(s2));
        System.out.println("预期：false");
        System.out.println();
        
        // 测试用例 3：空字符串
        String s3 = " ";
        System.out.println("测试用例 3：");
        System.out.println("输入：" + s3);
        System.out.println("输出：" + solution.isPalindrome(s3));
        System.out.println("预期：true");
    }
} 