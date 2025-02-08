// https://leetcode.cn/problems/count-and-say/
// 38. 外观数列
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 第一项是数字 1 
// 描述前一项，这个数是 1 即 "一个 1 "，记作 "11"
// 描述前一项，这个数是 11 即 "二个 1 " ，记作 "21"
// 描述前一项，这个数是 21 即 "一个 2 + 一个 1" ，记作 "1211"
// 描述前一项，这个数是 1211 即 "一个 1 + 一个 2 + 二个 1" ，记作 "111221"

public class L0038_CountAndSay {
    public String countAndSay(int n) {
        // 基本情况
        if (n == 1) {
            return "1";
        }
        
        // 递归获取前一个字符串
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        
        // 计数当前字符出现次数
        int count = 1;
        char currentChar = prev.charAt(0);
        
        // 遍历前一个字符串
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                // 添加当前字符的计数和字符本身
                result.append(count).append(currentChar);
                // 重置计数器，更新当前字符
                currentChar = prev.charAt(i);
                count = 1;
            }
        }
        
        // 添加最后一组字符的计数
        result.append(count).append(currentChar);
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0038_CountAndSay solution = new L0038_CountAndSay();
        
        // 测试用例
        System.out.println("n = 1: " + solution.countAndSay(1)); // 输出: "1"
        System.out.println("n = 4: " + solution.countAndSay(4)); // 输出: "1211"
    }
} 