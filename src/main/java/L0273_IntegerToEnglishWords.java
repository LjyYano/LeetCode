/**
 * https://leetcode.cn/problems/integer-to-english-words/
 * 
 * 将非负整数 num 转换为其对应的英文表示。
 * 
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 提示：
 * 0 <= num <= 2³¹ - 1
 */
public class L0273_IntegerToEnglishWords {
    
    // 1-19 的英文表示
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    // 十位数的英文表示
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    // 大数单位的英文表示
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        int i = 0;
        
        // 每三位数字一组进行处理
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder temp = new StringBuilder();
                helper(num % 1000, temp);
                words.insert(0, temp.append(THOUSANDS[i]).append(" "));
            }
            num /= 1000;
            i++;
        }
        
        return words.toString().trim();
    }
    
    // 处理三位数
    private void helper(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        }
        
        if (num < 20) {
            // 小于 20 的数字直接查表
            sb.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            // 处理两位数
            sb.append(TENS[num / 10]).append(" ");
            helper(num % 10, sb);
        } else {
            // 处理三位数
            sb.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(num % 100, sb);
        }
    }

    public static void main(String[] args) {
        L0273_IntegerToEnglishWords solution = new L0273_IntegerToEnglishWords();
        
        // 测试用例
        System.out.println(solution.numberToWords(123));  // One Hundred Twenty Three
        System.out.println(solution.numberToWords(12345));  // Twelve Thousand Three Hundred Forty Five
        System.out.println(solution.numberToWords(1234567));  // One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
        System.out.println(solution.numberToWords(0));  // Zero
    }
} 