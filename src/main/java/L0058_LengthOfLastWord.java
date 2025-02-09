/**
 * https://leetcode.cn/problems/length-of-last-word/
 * 
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是"World"，长度为5。
 * 
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是"moon"，长度为4。
 * 
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的"joyboy"。
 * 
 * 提示：
 * 1 <= s.length <= 10⁴
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */
public class L0058_LengthOfLastWord {
    
    public int lengthOfLastWord(String s) {
        // 特殊情况处理
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 从字符串末尾开始遍历
        int length = 0;
        int i = s.length() - 1;
        
        // 跳过末尾的空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        // 计算最后一个单词的长度
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }

    public static void main(String[] args) {
        L0058_LengthOfLastWord solution = new L0058_LengthOfLastWord();
        
        // 测试用例
        System.out.println("\"Hello World\" -> " + solution.lengthOfLastWord("Hello World")); // 预期输出：5
        System.out.println("\"   fly me   to   the moon  \" -> " + solution.lengthOfLastWord("   fly me   to   the moon  ")); // 预期输出：4
        System.out.println("\"luffy is still joyboy\" -> " + solution.lengthOfLastWord("luffy is still joyboy")); // 预期输出：6
    }
} 