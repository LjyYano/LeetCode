/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 
 * 注意：输入字符串 s 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不应包含额外的空格。
 * 
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 
 * 提示：
 * - 1 <= s.length <= 10⁴
 * - s 包含英文大小写字母、数字和空格 ' '
 * - s 中 至少存在一个 单词
 */
public class L0151_ReverseWordsInAString {
    
    public String reverseWords(String s) {
        // 去除前导空格、尾随空格和单词间的多余空格
        String[] words = s.trim().split("\\s+");
        
        // 反转单词数组
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // 用单个空格连接单词
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        L0151_ReverseWordsInAString solution = new L0151_ReverseWordsInAString();
        
        // 测试用例 1
        String s1 = "the sky is blue";
        System.out.println(solution.reverseWords(s1)); // 预期输出："blue is sky the"
        
        // 测试用例 2
        String s2 = "  hello world  ";
        System.out.println(solution.reverseWords(s2)); // 预期输出："world hello"
        
        // 测试用例 3
        String s3 = "a good   example";
        System.out.println(solution.reverseWords(s3)); // 预期输出："example good a"
    }
} 