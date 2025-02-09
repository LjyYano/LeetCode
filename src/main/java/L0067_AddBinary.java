/**
 * https://leetcode.cn/problems/add-binary/
 * 
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 
 * 示例 1：
 * 输入：a = "11", b = "1"
 * 输出："100"
 * 
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * 
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class L0067_AddBinary {

    // 从右往左遍历两个字符串，按位相加并处理进位
    public String addBinary(String a, String b) {
        // 结果字符串
        StringBuilder result = new StringBuilder();
        // 进位
        int carry = 0;
        // 从右往左遍历两个字符串
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 只要还有数字需要相加，就继续循环
        while (i >= 0 || j >= 0 || carry > 0) {
            // 获取当前位的值，如果已经遍历完了字符串，就用 0 代替
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;

            // 计算当前位的和
            int sum = digitA + digitB + carry;
            // 更新进位
            carry = sum / 2;
            // 当前位的结果
            result.insert(0, sum % 2);

            // 移动指针
            i--;
            j--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L0067_AddBinary solution = new L0067_AddBinary();

        // 测试用例 1
        String a1 = "11";
        String b1 = "1";
        System.out.println("Input: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a1, b1) + "\"");
        System.out.println();

        // 测试用例 2
        String a2 = "1010";
        String b2 = "1011";
        System.out.println("Input: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a2, b2) + "\"");
    }
} 