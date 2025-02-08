/**
 * 题目链接：https://leetcode.cn/problems/count-and-say/
 * 
 * 给定一个正整数 n，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1 
 * 描述前一项，这个数是 1 即 " 一 个 1 "，记作 "11"
 * 描述前一项，这个数是 11 即 " 二 个 1 " ，记作 "21"
 * 描述前一项，这个数是 21 即 " 一 个 2 一 个 1 " ，记作 "1211"
 * 描述前一项，这个数是 1211 即 " 一 个 1 一 个 2 二 个 1 " ，记作 "111221"
 */
public class L0038_CountAndSay {

    public String countAndSay(int n) {
        // 处理边界情况
        if (n == 1) {
            return "1";
        }

        // 获取前一项的结果
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        // 统计连续相同数字的个数
        int count = 1;
        char currentChar = prev.charAt(0);
        
        // 遍历前一项的每个字符
        for (int i = 1; i < prev.length(); i++) {
            // 如果当前字符与前一个字符相同，计数加1
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                // 如果不同，将计数和数字加入结果
                result.append(count).append(currentChar);
                // 重置计数器，更新当前字符
                count = 1;
                currentChar = prev.charAt(i);
            }
        }
        
        // 处理最后一组数字
        result.append(count).append(currentChar);
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0038_CountAndSay solution = new L0038_CountAndSay();
        
        // 测试用例
        System.out.println("n = 1: " + solution.countAndSay(1)); // 预期输出: "1"
        System.out.println("n = 2: " + solution.countAndSay(2)); // 预期输出: "11"
        System.out.println("n = 3: " + solution.countAndSay(3)); // 预期输出: "21"
        System.out.println("n = 4: " + solution.countAndSay(4)); // 预期输出: "1211"
        System.out.println("n = 5: " + solution.countAndSay(5)); // 预期输出: "111221"
    }
} 