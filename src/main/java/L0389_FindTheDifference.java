/**
 * https://leetcode.cn/problems/find-the-difference/
 * 
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * 
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * 
 * 提示：
 * - 0 <= s.length <= 1000
 * - t.length == s.length + 1
 * - s 和 t 只包含小写字母
 */
public class L0389_FindTheDifference {

    public char findTheDifference(String s, String t) {
        // 使用异或运算的性质：
        // 1. a ^ a = 0
        // 2. a ^ 0 = a
        // 3. 异或运算满足交换律和结合律
        char result = 0;
        
        // 对 s 中的所有字符进行异或运算
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        
        // 对 t 中的所有字符进行异或运算
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        
        // 最终结果就是被添加的字符
        return result;
    }

    public static void main(String[] args) {
        L0389_FindTheDifference solution = new L0389_FindTheDifference();

        // 测试用例 1
        String s1 = "abcd";
        String t1 = "abcde";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("输出：\"" + solution.findTheDifference(s1, t1) + "\"");
        System.out.println();

        // 测试用例 2
        String s2 = "";
        String t2 = "y";
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("输出：\"" + solution.findTheDifference(s2, t2) + "\"");
        System.out.println();

        // 测试用例 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("输出：\"" + solution.findTheDifference(s3, t3) + "\"");
        System.out.println();

        // 测试用例 4
        String s4 = "ae";
        String t4 = "aea";
        System.out.println("测试用例 4：");
        System.out.println("输入：s = \"" + s4 + "\", t = \"" + t4 + "\"");
        System.out.println("输出：\"" + solution.findTheDifference(s4, t4) + "\"");
    }
} 