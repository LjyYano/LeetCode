/**
 * https://leetcode.cn/problems/reverse-vowels-of-a-string/
 * 
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * 
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * 
 * 提示：
 * 1 <= s.length <= 3 * 10⁵
 * s 由可打印的 ASCII 字符组成
 */
public class L0345_ReverseVowelsOfString {
    
    public String reverseVowels(String s) {
        // 将字符串转为字符数组，方便修改
        char[] chars = s.toCharArray();
        
        // 使用双指针，从两端向中间移动
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            // 从左向右找到第一个元音字母
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            
            // 从右向左找到第一个元音字母
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            
            // 交换两个元音字母
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        // 将字符数组转回字符串
        return new String(chars);
    }
    
    // 判断字符是否为元音字母
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        L0345_ReverseVowelsOfString solution = new L0345_ReverseVowelsOfString();
        
        // 测试用例
        System.out.println("hello -> " + solution.reverseVowels("hello"));     // 应该输出 "holle"
        System.out.println("leetcode -> " + solution.reverseVowels("leetcode")); // 应该输出 "leotcede"
        System.out.println("aA -> " + solution.reverseVowels("aA"));           // 应该输出 "Aa"
        System.out.println(".,? -> " + solution.reverseVowels(".,?"));         // 应该输出 ".,?"
        System.out.println("aeiou -> " + solution.reverseVowels("aeiou"));     // 应该输出 "uoiea"
    }
} 