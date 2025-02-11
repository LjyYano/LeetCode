/**
 * https://leetcode.cn/problems/decode-string/
 * 
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 
 * 提示：
 * - 1 <= s.length <= 30
 * - s 由小写英文字母、数字和方括号 '[]' 组成
 * - s 保证是一个 有效 的输入。
 * - s 中所有整数的取值范围为 [1, 300]
 */
public class L0394_DecodeString {
    
    private int index = 0;
    
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        
        while (index < s.length() && s.charAt(index) != ']') {
            // 如果不是数字，直接添加到结果中
            if (!Character.isDigit(s.charAt(index))) {
                result.append(s.charAt(index++));
            } else {
                // 获取重复次数
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + s.charAt(index++) - '0';
                }
                
                // 跳过左括号
                index++;
                
                // 递归解码括号内的内容
                String decodedString = decodeString(s);
                
                // 跳过右括号
                index++;
                
                // 重复 k 次
                while (k > 0) {
                    result.append(decodedString);
                    k--;
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0394_DecodeString solution = new L0394_DecodeString();
        
        // 测试用例 1
        String s1 = "3[a]2[bc]";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\"");
        System.out.println("输出：\"" + solution.decodeString(s1) + "\"");
        System.out.println();
        
        // 重置索引
        solution.index = 0;
        
        // 测试用例 2
        String s2 = "3[a2[c]]";
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\"");
        System.out.println("输出：\"" + solution.decodeString(s2) + "\"");
        System.out.println();
        
        // 重置索引
        solution.index = 0;
        
        // 测试用例 3
        String s3 = "2[abc]3[cd]ef";
        System.out.println("测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\"");
        System.out.println("输出：\"" + solution.decodeString(s3) + "\"");
        System.out.println();
        
        // 重置索引
        solution.index = 0;
        
        // 测试用例 4
        String s4 = "abc3[cd]xyz";
        System.out.println("测试用例 4：");
        System.out.println("输入：s = \"" + s4 + "\"");
        System.out.println("输出：\"" + solution.decodeString(s4) + "\"");
    }
} 