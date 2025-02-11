import java.util.*;

/**
 * https://leetcode.cn/problems/number-of-segments-in-a-string/description/
 * 
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * 示例 1：
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * 
 * 示例 2：
 * 输入: "Hello"
 * 输出: 1
 * 
 * 示例 3：
 * 输入: "love live! mu'sic forever"
 * 输出: 4
 * 
 * 示例 4：
 * 输入: ""
 * 输出: 0
 */
public class L0434_NumberOfSegmentsInAString {

    public int countSegments(String s) {
        // 特殊情况处理
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        // 遍历字符串，如果当前字符不是空格，且前一个字符是空格（或是第一个字符），则找到一个新的单词
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0434_NumberOfSegmentsInAString solution = new L0434_NumberOfSegmentsInAString();
        
        // 测试用例1
        String s1 = "Hello, my name is John";
        System.out.println("测试用例1：");
        System.out.println("输入：\"" + s1 + "\"");
        System.out.println("输出：" + solution.countSegments(s1));
        
        // 测试用例2
        String s2 = "Hello";
        System.out.println("\n测试用例2：");
        System.out.println("输入：\"" + s2 + "\"");
        System.out.println("输出：" + solution.countSegments(s2));
        
        // 测试用例3
        String s3 = "love live! mu'sic forever";
        System.out.println("\n测试用例3：");
        System.out.println("输入：\"" + s3 + "\"");
        System.out.println("输出：" + solution.countSegments(s3));
        
        // 测试用例4
        String s4 = "";
        System.out.println("\n测试用例4：");
        System.out.println("输入：\"" + s4 + "\"");
        System.out.println("输出：" + solution.countSegments(s4));
    }
} 